package by.zharikov.myapplication.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.activity_homework3.*

class Homework3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework3)
        val brestViewModel = ViewModelProvider(this).get(BrestViewModel::class.java)
        brestViewModel.counterPotatoes.observe(this, Observer {
            textView.text = it.toString()
        })
        brestViewModel.counterCabbage.observe(this, Observer {
            textView2.text = it.toString()
        })
        brestViewModel.counterBeet.observe(this, Observer {
            textView3.text = it.toString()
        })

        val vitebskViewModel = ViewModelProvider(this).get(VitebskViewModel::class.java)
        vitebskViewModel.counterPotatoes.observe(this, Observer {
            textView4.text = it.toString()
        })
        vitebskViewModel.counterCabbage.observe(this, Observer {
            textView5.text = it.toString()
        })
        vitebskViewModel.counterBeet.observe(this, Observer {
            textView6.text = it.toString()
        })

        val gomelViewModel = ViewModelProvider(this).get(GomelViewModel::class.java)
        gomelViewModel.counterPotatoes.observe(this, Observer {
            textView7.text = it.toString()
        })
        gomelViewModel.counterCabbage.observe(this, Observer {
            textView8.text = it.toString()
        })
        gomelViewModel.counterBeet.observe(this, Observer {
            textView9.text = it.toString()
        })

        val grodnoViewModel = ViewModelProvider(this).get(GrodnoViewModel::class.java)
        grodnoViewModel.counterPotatoes.observe(this, Observer {
            textView10.text = it.toString()
        })
        grodnoViewModel.counterCabbage.observe(this, Observer {
            textView11.text = it.toString()
        })
        grodnoViewModel.counterBeet.observe(this, Observer {
            textView12.text = it.toString()
        })

        val minskViewModel = ViewModelProvider(this).get(MinskViewModel::class.java)
        minskViewModel.counterPotatoes.observe(this, Observer {
            textView13.text = it.toString()
        })
        minskViewModel.counterCabbage.observe(this, Observer {
            textView14.text = it.toString()
        })
        minskViewModel.counterBeet.observe(this, Observer {
            textView15.text = it.toString()
        })

        val mogilevViewModel = ViewModelProvider(this).get(MogilevViewModel::class.java)
        mogilevViewModel.counterPotatoes.observe(this, Observer {
            textView17.text = it.toString()
        })
        mogilevViewModel.counterCabbage.observe(this, Observer {
            textView18.text = it.toString()
        })
        mogilevViewModel.counterBeet.observe(this, Observer {
            textView19.text = it.toString()
        })

        button_start_harvesting.setOnClickListener {
            brestViewModel.harvesting()
            vitebskViewModel.harvesting()
            gomelViewModel.harvesting()
            grodnoViewModel.harvesting()
            minskViewModel.harvesting()
            mogilevViewModel.harvesting()
            button_start_harvesting.isEnabled = false
            brestViewModel.winnerRegion.observe(this, Observer {
                if (brestViewModel.winnerRegion.value!!) {
                    Toast.makeText(this, "BREST REGION IS WIN", Toast.LENGTH_SHORT).show()
                    vitebskViewModel.winner = true
                    gomelViewModel.winner = true
                    grodnoViewModel.winner = true
                    minskViewModel.winner = true
                    mogilevViewModel.winner = true
                }
            })
            vitebskViewModel.winnerRegion.observe(this, Observer {
                if (vitebskViewModel.winnerRegion.value!!) {
                    Toast.makeText(this, "VITEBSK REGION IS WIN", Toast.LENGTH_SHORT).show()
                    brestViewModel.winner = true
                    gomelViewModel.winner = true
                    grodnoViewModel.winner = true
                    minskViewModel.winner = true
                    mogilevViewModel.winner = true
                }
            })
            gomelViewModel.winnerRegion.observe(this, Observer {
                if (gomelViewModel.winnerRegion.value!!) {
                    Toast.makeText(this, "GOMEL REGION IS WIN", Toast.LENGTH_SHORT).show()
                    vitebskViewModel.winner = true
                    brestViewModel.winner = true
                    grodnoViewModel.winner = true
                    minskViewModel.winner = true
                    mogilevViewModel.winner = true
                }
            })
            grodnoViewModel.winnerRegion.observe(this, Observer {
                if (grodnoViewModel.winnerRegion.value!!) {
                    Toast.makeText(this, "GRODNO REGION IS WIN", Toast.LENGTH_SHORT).show()
                    vitebskViewModel.winner = true
                    gomelViewModel.winner = true
                    brestViewModel.winner = true
                    minskViewModel.winner = true
                    mogilevViewModel.winner = true
                }
            })
            minskViewModel.winnerRegion.observe(this, Observer {
                if (minskViewModel.winnerRegion.value!!) {
                    Toast.makeText(this, "MINSK REGION IS WIN", Toast.LENGTH_SHORT).show()
                    vitebskViewModel.winner = true
                    gomelViewModel.winner = true
                    grodnoViewModel.winner = true
                    brestViewModel.winner = true
                    mogilevViewModel.winner = true
                }
            })
            mogilevViewModel.winnerRegion.observe(this, Observer {
                if (mogilevViewModel.winnerRegion.value!!) {
                    Toast.makeText(this, "MOGILEV REGION IS WIN", Toast.LENGTH_SHORT).show()
                    vitebskViewModel.winner = true
                    gomelViewModel.winner = true
                    grodnoViewModel.winner = true
                    minskViewModel.winner = true
                    brestViewModel.winner = true
                }
            })
        }


    }


}
