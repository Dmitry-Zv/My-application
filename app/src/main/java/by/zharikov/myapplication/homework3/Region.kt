package by.zharikov.myapplication.homework3

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlin.random.Random

abstract class Region(val name: String, var winner: Boolean) {
    var counterPotatoes = MutableLiveData(0)
    var counterCabbage = MutableLiveData(0)
    var counterBeet = MutableLiveData(0)
    suspend fun harvest() {
        var counter = counterPotatoes.value
        var counter2 = counterCabbage.value
        var counter3 = counterBeet.value
        val random = Random
        while ((counterBeet.value!! < 100) or (counterCabbage.value!! < 100) or (counterPotatoes.value!! < 100)) {
            delay(1000)
            counter = counter?.plus(random.nextInt(10))
            counter2 = counter2?.plus(random.nextInt(10))
            counter3 = counter3?.plus(random.nextInt(10))
            counterPotatoes.postValue(counter)
            counterCabbage.postValue(counter2)
            counterBeet.postValue(counter3)
            if ((counterBeet.value!! >= 100) and (counterCabbage.value!! >= 100) and (counterPotatoes.value!! >= 100))
                winner = true
        }
    }
}