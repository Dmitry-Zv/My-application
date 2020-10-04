package by.zharikov.myapplication.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_home_page.*

private const val NAME_KEY ="name key"
class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val name = intent.getStringExtra(NAME_KEY)
        text_view_hp.text = "Welcome $name!"
    }
}