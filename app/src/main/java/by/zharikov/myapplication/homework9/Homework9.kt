package by.zharikov.myapplication.homework9

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import by.zharikov.myapplication.R


class Homework9 : AppCompatActivity() {
    lateinit var timerPicker: TimePicker
    lateinit var timer: TextView
    lateinit var countDownTimer : CountDownTimer

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework9)
        timerPicker = findViewById<TimePicker>(R.id.timer_picker)
        timer = findViewById<TextView>(R.id.text_timer)
        timerPicker.setIs24HourView(true)
        timerPicker.minute = 0
        timerPicker.hour = 0
        timerPicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            timer.text = "$hourOfDay : $minute"
            val intent = Intent(this, MyForegroundService::class.java)
            val btnStartTimer = findViewById<Button>(R.id.button_start_countdown)
            val btnStopTimer = findViewById<Button>(R.id.button_stop_countdown)
            val timeInSeconds = (timerPicker.hour * 60 + timerPicker.minute)*60
            btnStartTimer.setOnClickListener {
                timer.text = "${timerPicker.hour} : ${timerPicker.minute}"
                countDownTimer = object : CountDownTimer(timeInSeconds * 1000L, 1000) {

                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onTick(millisUntilFinished: Long) {
                        val minutes = millisUntilFinished / 60000
                        val seconds = millisUntilFinished / 1000
                        timer.text = "$minutes : $seconds"
                    }

                    @RequiresApi(Build.VERSION_CODES.O)
                    override fun onFinish() {
                        startService(intent)
                    }
                }
                countDownTimer.start()
            }
            btnStopTimer.setOnClickListener {
                countDownTimer.cancel()
                timer.text = "0:0"
            }
        }


    }

}
