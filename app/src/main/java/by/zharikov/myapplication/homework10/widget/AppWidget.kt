package by.zharikov.myapplication.homework10.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework10.Homework10
import by.zharikov.myapplication.homework10.mapper.WeatherMapper
import by.zharikov.myapplication.homework10.retrofit.RetrofitFactoryWeather
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [AppWidgetConfigureActivity]
 */
private const val APP_ID = "066684c224288ec83f079c8017eb1057"
private const val UNITS = "metric"
private const val LANG = "ru"
private const val REQUEST_HOME = 111
private const val REQUEST_UPDATE = 222

class AppWidget : AppWidgetProvider() {
    lateinit var remoteLayout: RemoteViews
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        remoteLayout = RemoteViews(context.packageName, R.layout.app_widget)

        val homeIntent = PendingIntent.getActivity(
            context,
            REQUEST_HOME,
            Intent(context, Homework10::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        remoteLayout.setOnClickPendingIntent(R.id.home_widget, homeIntent)

        val actionUpdateIntent = Intent()
        actionUpdateIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE

        val updateIntent = PendingIntent.getBroadcast(
            context,
            REQUEST_UPDATE,
            actionUpdateIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        remoteLayout.setOnClickPendingIntent(R.id.update_widget, updateIntent)

        appWidgetManager.updateAppWidget(appWidgetIds, remoteLayout)
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.app_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
    val retrofit = RetrofitFactoryWeather.getRetrofit()
    CoroutineScope(Dispatchers.IO).launch {
        val response =
            retrofit.getWeatherAsync(loadTitlePref(context, appWidgetId), APP_ID, UNITS, LANG)
                .await()
        if (response.isSuccessful) {
            val weather = response.body()?.let {
                WeatherMapper().convert(it)
            }
            val city = weather?.cityName
            val temp = weather?.temp
            val pressure = weather?.pressure
            val humidity = weather?.humidity
            val icon =
           Picasso.get().load("https://openweathermap.org/img/wn/${weather?.icon}@2x.png").get()
            val remoteLayout = RemoteViews(context.packageName, R.layout.app_widget)
            withContext(Dispatchers.Main) {
                remoteLayout.setTextViewText(
                    R.id.temperature, String.format("%.2f", (temp))
                            + "\u00b0" + "C"
                )
                remoteLayout.setTextViewText(R.id.appwidget_text, city)
                remoteLayout.setTextViewText(R.id.pressure, pressure.toString())
                remoteLayout.setTextViewText(R.id.humidity, "${humidity.toString()} %")
                remoteLayout.setImageViewBitmap(R.id.icon_image, icon)
            }

        }
    }
}
