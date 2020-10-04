package by.zharikov.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.fragment_add_sort.*

class AddSortFragment : Fragment() {
    interface AddCoffee {
        fun addCoffee()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_sort, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_add.setOnClickListener {
            if (coffee_name_edit_text.text.isNullOrEmpty() or coffee_cost_edit_text.text.isNullOrEmpty() or url_edit_text.text.isNullOrEmpty()) {
                Toast.makeText(context, "You should fill in all fields!", Toast.LENGTH_SHORT).show()
            } else {

                val addCoffee = context as AddCoffee
                addCoffee.addCoffee()
                coffee_name_edit_text.text.clear()
                coffee_cost_edit_text.text.clear()
                url_edit_text.text.clear()
            }
        }
    }
}