package by.zharikov.myapplication.homework8.networking

import by.zharikov.myapplication.homework8.dto.CryptoCurrencyResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
private const val VALUE = "v1/cryptocurrency/listings/latest"
interface CryptoCurrencyAPI{
    @GET(VALUE)
    fun getCryptoCurrency():Deferred<Response<CryptoCurrencyResponse>>
}