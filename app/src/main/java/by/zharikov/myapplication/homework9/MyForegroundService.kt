package by.zharikov.myapplication.homework9

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import by.zharikov.myapplication.R

private const val LOG = "Log"

class MyForegroundService : Service() {
    private lateinit var notification: Notification
    lateinit var manager: NotificationManager
    override fun onCreate() {
        super.onCreate()
        Log.i(LOG, "onCreate")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForeground(1, gNotification())

        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        Log.i(LOG, "onDestroy")
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun gNotification(): Notification {
        val intentHomework9 = Intent(this, Homework9::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this, 1, intentHomework9, PendingIntent.FLAG_CANCEL_CURRENT
        )
        notification = Notification.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("NOTIFICATION")
            .setContentText("Timer is over")
            .setSmallIcon(R.drawable.ic_timer_off)
            .setContentIntent(pendingIntent)
            .build()
        return notification
    }
}
