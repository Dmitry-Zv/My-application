package by.zharikov.myapplication.homework10.networking

import by.zharikov.myapplication.homework10.dto.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val VALUE = "weather"
interface WeatherAPI {
    @GET(VALUE)
    fun getWeatherAsync(
        @Query("q")
        q:String,
        @Query("appid")
        appid:String,
        @Query("units")
        units:String,
        @Query("lang")
        lang:String
    ):Deferred<Response<WeatherResponse>>
}