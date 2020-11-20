package by.zharikov.myapplication.homework12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework12.utils.FibonacciNumbers
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.lang.NumberFormatException

class Homework12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework12)
        findViewById<Button>(R.id.button_start_fibonacci).setOnClickListener {
            val inputNumber = findViewById<EditText>(R.id.input_number_edit_text)
            try {
                val number = inputNumber.text.toString().toInt()
                val fibonacciNumber = FibonacciNumbers.validate(number)
                findViewById<TextView>(R.id.fibonacci_number_text).text = fibonacciNumber.toString()

            } catch (e:NumberFormatException){
                MaterialAlertDialogBuilder(this)
                    .setTitle(getString(R.string.error))
                    .setMessage(getString(R.string.number_wrong))
                    .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                        dialog.cancel()
                    }
                    .show()
            }

        }

    }
}