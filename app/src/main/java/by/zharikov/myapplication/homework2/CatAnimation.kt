package by.zharikov.myapplication.homework2

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_cat_animation.*

class CatAnimation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_animation)
        val animation = imageViewCat.drawable as AnimationDrawable
        animation.start()
    }
}