package by.zharikov.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.zharikov.myapplication.homework2.Homework2
import by.zharikov.myapplication.homework3.Homework3
import by.zharikov.myapplication.homework4.Homework4
import by.zharikov.myapplication.homework5.Homework5
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
            val intent = Intent(this, Homework2::class.java )
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
    }
}