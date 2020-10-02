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

            val addCoffee = context as AddCoffee
            addCoffee.addCoffee()
        }
    }
}