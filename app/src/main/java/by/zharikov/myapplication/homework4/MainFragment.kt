package by.zharikov.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_fragment_hw4.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment_hw4, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        add_sort_button.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.showAddSortFragment)
        }
        coffee_list_button.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.showCoffeeCollectionFragment)
        }
    }
}