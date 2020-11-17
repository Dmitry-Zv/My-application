package by.zharikov.myapplication.homework10.mapper

import by.zharikov.myapplication.homework10.dto.WeatherResponse
import by.zharikov.myapplication.homework10.entity.MyWeather

class WeatherMapper {
    fun convert(
        from: WeatherResponse
    ): MyWeather {
        return MyWeather(
            description = from.weather?.get(0)?.description.orEmpty(),
            icon = from.weather?.get(0)?.icon.orEmpty(),
            cityName = from.name.orEmpty(),
            temp = from.main?.temp?:0.0,
            humidity = from.main?.humidity?:0.0,
            pressure = from.main?.pressure?:0.0
        )

    }
}