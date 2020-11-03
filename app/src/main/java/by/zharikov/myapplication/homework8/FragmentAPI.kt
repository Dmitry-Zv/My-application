package by.zharikov.myapplication.homework8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.zharikov.myapplication.R
import kotlinx.android.synthetic.main.api_fragment.*

class FragmentAPI : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.api_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        get_crypto_currency_button.setOnClickListener {

            findNavController().navigate(R.id.showFragmentCryptocurrency)

        }
    }

}