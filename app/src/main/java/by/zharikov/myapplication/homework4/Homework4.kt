package by.zharikov.myapplication.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.zharikov.myapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_add_sort.*

class Homework4 : AppCompatActivity(), AddSortFragment.AddCoffee, CoffeeFragment.GetCoffeeList {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework4)
    }
    var counter = 0
    private var coffeeList = mutableListOf<Coffee>()
    override fun getCoffeeList(): MutableList<Coffee> {
        return coffeeList
    }

    override fun addCoffee() {

        val coffee = Coffee(
            name = coffee_name_edit_text.text.toString(),
            price = coffee_cost_edit_text.text.toString().toDouble(),
            imageUrl = url_edit_text.text.toString()
        )
        coffeeList.add(counter, coffee )
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.success))
            .setMessage(resources.getString(R.string.success_coffee))
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->
                dialog.cancel()
            }
            .show()
        counter++
    }

}
