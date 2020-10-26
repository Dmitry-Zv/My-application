package by.zharikov.myapplication.homework8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework8.adapter.RecyclerAdapter
import by.zharikov.myapplication.homework8.mapper.CryptoCurrencyMapper
import by.zharikov.myapplication.homework8.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.recycle_crypto_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentCryptoCurrency :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycle_crypto_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progress_bar.visibility = View.VISIBLE
        val retrofit = RetrofitFactory.getRetrofit()
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getCryptoCurrency().await()
            if (response.isSuccessful){
                val cryptoCurrencyResponse = response.body()
                val cryptoCurrency = response.body()?.data?.map {
                    CryptoCurrencyMapper().convert(it)
                }
                withContext(Dispatchers.Main){
                    val adapter = RecyclerAdapter(cryptoCurrency ?: listOf())
                    recycler_crypto_currency.adapter = adapter
                    recycler_crypto_currency.layoutManager = LinearLayoutManager(context)
                    progress_bar.visibility = View.GONE
                    recycler_crypto_currency.visibility = View.VISIBLE
                }
            }

        }
    }

}