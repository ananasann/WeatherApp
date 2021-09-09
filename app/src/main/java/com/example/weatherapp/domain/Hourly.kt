package com.example.weatherapp.domain

import com.example.weatherapp.data.WeatherBody

data class Hourly(
    val dt : Int,
    val temp : Double,
    val feels_like : Double,
    val weatherBody : List<WeatherBody>
)
