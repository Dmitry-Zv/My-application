package by.zharikov.myapplication.homework8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework8.entity.CryptoCurrency
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_crypto_currency.view.*

private const val URL_IMAGE = "https://s2.coinmarketcap.com/static/img/coins/64x64/"

class RecyclerAdapter(private val cryptoCurrency: List<CryptoCurrency>) :
    RecyclerView.Adapter<RecyclerAdapter.CryptoCurrencyViewHolder>() {

    class CryptoCurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_crypto_currency, parent, false)
        return CryptoCurrencyViewHolder(view)
    }

    override fun getItemCount() =
        cryptoCurrency.size

    override fun onBindViewHolder(holder: CryptoCurrencyViewHolder, position: Int) {
        holder.itemView.item_crypto_name.text = cryptoCurrency[position].cryptoCurrencyName
        holder.itemView.item_crypto_price.text = cryptoCurrency[position].priceCryptoCurrency.toString() + " $"

        holder.itemView.item_percent_change.text =
            cryptoCurrency[position].percentChange.toString() + " %"
        Picasso.get().load(URL_IMAGE + "${cryptoCurrency[position].id}.png")
            .into(holder.itemView.image_crypto_currency)
    }
}