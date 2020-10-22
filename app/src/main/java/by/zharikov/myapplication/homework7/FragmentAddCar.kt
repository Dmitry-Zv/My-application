package by.zharikov.myapplication.homework7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework7.entity.Car
import by.zharikov.myapplication.homework7.utils.launchIO
import by.zharikov.myapplication.homework7.utils.launchUI
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_add_or_show_bd_elements.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentAddCar : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_or_show_bd_elements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = context?.let { Db.getDb(it).carDao() }
        button_add_to_database.setOnClickListener {
            if (edit_text_brand.text.isNullOrEmpty() or  edit_text_max_speed.text.isNullOrEmpty() or  edit_text_fuel_consumption.text.isNullOrEmpty()) {
                context?.let { it1 ->
                    MaterialAlertDialogBuilder(it1)
                        .setTitle(resources.getString(R.string.error))
                        .setMessage(resources.getString(R.string.error_text))
                        .setNeutralButton(resources.getString(R.string.ok)) { dialog, which ->
                            dialog.cancel()
                        }.show()
                }
            } else {
                val brand = edit_text_brand.text.toString()
                val speed = edit_text_max_speed.text.toString().toDouble()
                val fuelConsumption = edit_text_fuel_consumption.text.toString().toDouble()
                val car = Car(brand, speed, fuelConsumption)
                launchIO {
                    db?.addCar(car)
                    launchUI {
                        context?.let { it1 ->
                            MaterialAlertDialogBuilder(it1)
                                .setTitle(resources.getString(R.string.success))
                                .setMessage(resources.getString(R.string.db_add))
                                .setNeutralButton(resources.getString(R.string.ok)) { dialog, which ->
                                    dialog.cancel()
                                }.show()
                        }
                    }
                }
            }
            edit_text_brand.text?.clear()
            edit_text_max_speed.text?.clear()
            edit_text_fuel_consumption.text?.clear()
        }
        button_show_database.setOnClickListener {
            findNavController().navigate(R.id.showFragmentShowCars)
        }
        button_delete_database.setOnClickListener {
            launchIO {
                db?.deleteAllCars()
                launchUI {
                    context?.let { it1 ->
                        MaterialAlertDialogBuilder(it1)
                            .setTitle(resources.getString(R.string.success))
                            .setMessage(resources.getString(R.string.db_delete_message))
                            .setNeutralButton(resources.getString(R.string.ok)) { dialog, which ->
                                dialog.cancel()
                            }.show()
                    }
                }
            }
        }
    }
}