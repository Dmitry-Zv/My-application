package by.zharikov.myapplication.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_homework3.*

class Homework3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework3)
        val regionViewModel = ViewModelProvider(this).get(RegionViewModel::class.java)

        button_start_harvesting.setOnClickListener {

            regionViewModel.findWinner()
            regionViewModel.brestRegion.counterPotatoes.observe(this, Observer {
                textView.text = it.toString()
            })
            regionViewModel.brestRegion.counterCabbage.observe(this, Observer {
                textView2.text = it.toString()
            })
            regionViewModel.brestRegion.counterBeet.observe(this, Observer {
                textView3.text = it.toString()
            })
            regionViewModel.vitebskRegion.counterPotatoes.observe(this, Observer {
                textView4.text = it.toString()
            })
            regionViewModel.vitebskRegion.counterCabbage.observe(this, Observer {
                textView5.text = it.toString()
            })
            regionViewModel.vitebskRegion.counterBeet.observe(this, Observer {
                textView6.text = it.toString()
            })
            regionViewModel.gomelRegion.counterPotatoes.observe(this, Observer {
                textView7.text = it.toString()
            })
            regionViewModel.gomelRegion.counterCabbage.observe(this, Observer {
                textView8.text = it.toString()
            })
            regionViewModel.gomelRegion.counterBeet.observe(this, Observer {
                textView9.text = it.toString()
            })
            regionViewModel.grodnoRegion.counterPotatoes.observe(this, Observer {
                textView10.text = it.toString()
            })
            regionViewModel.grodnoRegion.counterCabbage.observe(this, Observer {
                textView11.text = it.toString()
            })
            regionViewModel.grodnoRegion.counterBeet.observe(this, Observer {
                textView12.text = it.toString()
            })
            regionViewModel.minskRegion.counterPotatoes.observe(this, Observer {
                textView13.text = it.toString()
            })
            regionViewModel.minskRegion.counterCabbage.observe(this, Observer {
                textView14.text = it.toString()
            })
            regionViewModel.minskRegion.counterBeet.observe(this, Observer {
                textView15.text = it.toString()
            })
            regionViewModel.mogilevRegion.counterPotatoes.observe(this, Observer {
                textView17.text = it.toString()
            })
            regionViewModel.mogilevRegion.counterCabbage.observe(this, Observer {
                textView18.text = it.toString()
            })
            regionViewModel.mogilevRegion.counterBeet.observe(this, Observer {
                textView19.text = it.toString()
            })
            regionViewModel.winnerRegion.observe(this, Observer {

                Toast.makeText(
                    this,
                    "${regionViewModel.winnerRegion.value!!.name} is ${regionViewModel.winnerPlace.value!!} place",
                    Toast.LENGTH_SHORT
                ).show()

            })
            button_start_harvesting.isEnabled = false
        }
    }
}
