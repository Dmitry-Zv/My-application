package by.zharikov.myapplication.homework6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.postcard_fragment1.*

class PostcardFragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.postcard_fragment1, container,  false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        open_postcard_button.setOnClickListener {
            val nav = findNavController()
            nav.navigate(R.id.showPostcardFragment2)
        }
    }
}