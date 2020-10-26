package by.zharikov.myapplication.homework8.retrofit

import by.zharikov.myapplication.homework8.networking.CryptoCurrencyAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "https://pro-api.coinmarketcap.com/"
private const val KEY_NAME = "X-CMC_PRO_API_KEY"
private const val KEY_VALUE = "eb58ea2f-1d43-405f-bb97-ef01946db5fb"

object RetrofitFactory {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader(KEY_NAME, KEY_VALUE)
                    .build()
                return chain.proceed(request)
            }

        })

    fun getRetrofit(): CryptoCurrencyAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client.build())
            .build()
        return retrofit.create()
    }
}