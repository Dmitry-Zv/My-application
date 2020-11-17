package by.zharikov.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.zharikov.myapplication.homework11.Homework11
import by.zharikov.myapplication.homework2.Homework2
import by.zharikov.myapplication.homework3.Homework3
import by.zharikov.myapplication.homework4.Homework4
import by.zharikov.myapplication.homework5.Homework5
import by.zharikov.myapplication.homework6.Homework6
import by.zharikov.myapplication.homework7.Homework7
import by.zharikov.myapplication.homework8.Homework8
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this, Homework1::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, Homework2::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, Homework3::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, Homework4::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, Homework5::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this, Homework6::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            val intent = Intent(this, Homework7::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent = Intent(this, Homework8::class.java)
            startActivity(intent)
        }
        button11.setOnClickListener {
            startActivity(Intent(this, Homework11::class.java))
        }
    }
}