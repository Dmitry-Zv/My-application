package by.zharikov.myapplication.homework7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework7.adapter.CarRecycleAdapter
import by.zharikov.myapplication.homework7.entity.Car
import by.zharikov.myapplication.homework7.utils.launchIO
import by.zharikov.myapplication.homework7.utils.launchUI
import kotlinx.android.synthetic.main.fragment_database.*

class FragmentShowCars : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_database, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = context?.let { Db.getDb(it).carDao() }
        var cars: List<Car> = listOf()
        launchIO {
            if (db != null) {
                cars = db.getCars()
                launchUI {
                    val adapter = CarRecycleAdapter(cars)
                    cars_recycler.adapter = adapter
                    cars_recycler.layoutManager = LinearLayoutManager(context)
                }

            }
        }
        edit_text_search_car.addTextChangedListener {
            cars_recycler.adapter = CarRecycleAdapter(cars.filter { car ->
                car.brand.contains(edit_text_search_car.text.toString())
            })
        }


    }

}