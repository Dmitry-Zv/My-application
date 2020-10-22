package by.zharikov.myapplication.homework7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework7.dao.CarDao
import by.zharikov.myapplication.homework7.entity.Car
import kotlinx.android.synthetic.main.fragment_add_or_show_bd_elements.view.*
import kotlinx.android.synthetic.main.item_car.view.*

class CarRecycleAdapter(private val car: List<Car>): RecyclerView.Adapter<CarRecycleAdapter.CarViewHolder>() {

    class CarViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false )
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return car.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.itemView.brand_text_view.text = car[position].brand
        holder.itemView.max_speed_text_view.text = car[position].maxSpeed.toString()
        holder.itemView.fuel_consumption_text_view.text = car[position].fuelConsumption.toString()
    }
}