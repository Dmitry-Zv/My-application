package by.zharikov.myapplication.homework6

import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import by.zharikov.myapplication.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.postcard_fragment2.*
import kotlinx.coroutines.*

class PostcardFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.postcard_fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idOfTexts = listOf<TextView>(
            message_for_mother,
            message_for_mother2,
            message_for_mother3,
            message_for_mother4,
            message_for_mother5
        )
        val message = listOf<String>(
            resources.getString(R.string.mother_message1),
            resources.getString(R.string.mother_message2),
            resources.getString(R.string.mother_message3),
            resources.getString(R.string.mother_message4),
            resources.getString(R.string.mother_message5)
        )
        CoroutineScope(Dispatchers.IO).launch { createAnim(idOfTexts, message) }

    }

    private suspend fun createAnim(idOfTexts: List<TextView>, message: List<String>) {
        var count = 0
        withContext(Dispatchers.Main) {
            delay(1000)
            for (id in idOfTexts) {
                id.text = message[count++]
                YoYo.with(Techniques.RollIn)
                    .duration(500)
                    .playOn(id)
                delay(3000)
            }
        }
    }

}