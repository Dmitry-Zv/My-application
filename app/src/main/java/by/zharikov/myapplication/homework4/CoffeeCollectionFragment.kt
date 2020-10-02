package by.zharikov.myapplication.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.zharikov.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_homework1.*
import kotlinx.android.synthetic.main.fragment_coffee.*

class CoffeeCollectionFragment : Fragment() {
    interface GetCoffeeList{
        fun getCoffeeList():MutableList<Coffee>
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
        val getCoffeeList = context as GetCoffeeList
        var coffeeList =  getCoffeeList.getCoffeeList()
        for (coffee in coffeeList){
            coffee_name_text_view.text = coffee.name
            coffee_cost_text_view.text = coffee.price.toString()
            Picasso.get().load(coffee.imageUrl).into(coffee_image_view)
        }
    }
}