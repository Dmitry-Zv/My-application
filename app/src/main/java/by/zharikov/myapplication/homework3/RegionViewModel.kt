package by.zharikov.myapplication.homework3

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

abstract class  RegionViewModel() : ViewModel() {
    var counterPotatoes = MutableLiveData(0)
    var counterCabbage = MutableLiveData(0)
    var counterBeet = MutableLiveData(0)
    var winnerRegion = MutableLiveData(false)
    var winner = false
    fun harvesting() {
        var counter = counterPotatoes.value
        var counter2 = counterCabbage.value
        var counter3 = counterBeet.value
        val random = Random

        CoroutineScope(Dispatchers.IO).launch {
            while (!winner) {
                delay(1500)
                counter = counter?.plus(random.nextInt(10))
                counter2 = counter2?.plus(random.nextInt(10))
                counter3 = counter3?.plus(random.nextInt(10))
                counterPotatoes.postValue(counter)
                counterCabbage.postValue(counter2)
                counterBeet.postValue(counter3)
                if (counterPotatoes.value!! > 100 && counterCabbage.value!! > 100 && counterBeet.value!! > 100){
                    winner = true
                    winnerRegion.postValue(winner)
                }
            }
        }
    }
}