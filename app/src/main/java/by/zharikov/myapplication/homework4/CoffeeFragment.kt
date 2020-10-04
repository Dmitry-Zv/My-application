package by.zharikov.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.zharikov.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_coffee.*

open class CoffeeFragment : Fragment() {
    interface GetCoffeeList {
        fun getCoffeeList(): MutableList<Coffee>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coffee, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val coffeeIdName = arrayListOf<TextView>(
            coffee_name_text_view,
            coffee_name_text_view2,
            coffee_name_text_view3
        )
        val coffeeIdCost = arrayListOf<TextView>(
            coffee_cost_text_view,
            coffee_cost_text_view2,
            coffee_cost_text_view3
        )
        val coffeeIdImage = arrayListOf<ImageView>(
            coffee_image_view,
            coffee_image_view2,
            coffee_image_view3
        )
        val getCoffeeList = context as CoffeeFragment.GetCoffeeList
        val coffeeList = getCoffeeList.getCoffeeList()
        for ((count, coffee) in coffeeList.withIndex()) {
            coffeeIdName[count].text = coffee.name
            coffeeIdCost[count].text = coffee.price.toString()
            Picasso.get().load(coffee.imageUrl).into(coffeeIdImage[count])
        }
    }
}