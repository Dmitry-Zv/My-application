package by.zharikov.myapplication.homework3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class RegionViewModel() : ViewModel() {
    var brestRegion = BrestRegion("Brest Region", false)
    var vitebskRegion = VitebskRegion("Vitebsk Region", false)
    var gomelRegion = GomelRegion("Gomel Region", false)
    var grodnoRegion = GrodnoRegion("Grodno Region", false)
    var minskRegion = MinskRegion("Minsk Region", false)
    var mogilevRegion = MogilevRegion("Mogilev Region", false)
    var winnerRegion = MutableLiveData<Region>()
    var winnerPlace = MutableLiveData(0)
    val regionArray = arrayListOf(
        brestRegion,
        vitebskRegion,
        gomelRegion,
        grodnoRegion,
        minskRegion,
        mogilevRegion
    )

    fun findWinner() {
        var counter = 1
        for (region in regionArray) {
            CoroutineScope(Dispatchers.IO).launch {
                region.harvest()
            }.invokeOnCompletion {
                if (region.winner) {
                    winnerRegion.postValue(region)
                    winnerPlace.postValue(counter)
                    counter++
                }
            }
        }
    }
}

