package by.zharikov.myapplication.homework11

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_homework11.*
import okhttp3.internal.parseCookie

class Homework11 : AppCompatActivity(), SensorEventListener {
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework11)
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        text = findViewById<TextView>(R.id.text_light)
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onSensorChanged(event: SensorEvent?) {
        val light = event?.values?.get(0)?:0.0f
        text.text = "Room illumination $light lux"
        if (light > 300){
            color_layout.setBackgroundColor(Color.parseColor(getString(R.string.green)))
        } else {
            color_layout.setBackgroundColor(Color.parseColor( getString(R.string.red)))
        }
    }
}