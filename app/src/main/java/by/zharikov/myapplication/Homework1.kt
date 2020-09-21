package by.zharikov.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_homework1.*

class Homework1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1)
        buttonLoad.setOnClickListener {
            val url = editText.text.toString()
            if (url.isNotEmpty()) {
                Picasso.get().load(url).into(imageView)
            }
        }
    }
}