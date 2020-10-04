package by.zharikov.myapplication.homework5

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import by.zharikov.myapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_homework5.*
import java.lang.Error
private const val NAME_KEY ="name key"
private const val PASSWORD_KEY ="password key"
class Homework5 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework5)
        edit_text_name_hw5.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                text_field_hw5.isErrorEnabled = true
                text_field_hw5.error = "Name must be not empty!"
            }
            else {
                text_field_hw5.error = null
            }
        }
        edit_text_password_hw5.addTextChangedListener {
            if (it.isNullOrEmpty() || it.length < 8) {
                text_field2_hw5.isErrorEnabled = true
                text_field2_hw5.error = "Password must be at least 8 characters!"
            } else{
                text_field2_hw5.error = null
            }
        }
        button_register.setOnClickListener {
            if (edit_text_name_hw5.text.isNullOrEmpty() or edit_text_password_hw5.text.isNullOrEmpty()) {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("All fields must be filled!")
                    .setPositiveButton("Ok") { dialog, which ->
                        dialog.cancel()
                    }
                    .show()
            } else {
                val myPerson = Person(edit_text_name_hw5.text.toString(), edit_text_password_hw5.text.toString())
                val intent = Intent(this, HomePage::class.java)
                intent.putExtra(NAME_KEY, myPerson.name)
                intent.putExtra(PASSWORD_KEY, myPerson.password)
                MaterialAlertDialogBuilder(this)
                    .setIcon(resources.getDrawable(R.drawable.login, theme))
                    .setTitle("Success")
                    .setMessage("You are register!")
                    .setNeutralButton("Ok") { dialog, which ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Come in"){dialog, which ->
                        startActivity(intent)
                        edit_text_name_hw5.text?.clear()
                        edit_text_password_hw5.text?.clear()
                    }
                    .show()
            }
        }
    }
}