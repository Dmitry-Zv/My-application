package by.zharikov.myapplication.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_homework2.*

class Homework2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework2)
        buttonFlag.setOnClickListener {
            val intent = Intent(this, Flag::class.java)
            startActivity(intent)
        }
    }
}