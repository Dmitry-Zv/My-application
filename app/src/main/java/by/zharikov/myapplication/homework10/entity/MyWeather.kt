package by.zharikov.myapplication.homework10.entity

data class MyWeather(
    val description: String,
    val icon: String,
    val temp: Double,
    val cityName: String,
    val humidity: Double,
    val pressure: Double
)