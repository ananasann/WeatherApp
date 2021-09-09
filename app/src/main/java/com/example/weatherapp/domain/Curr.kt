package com.example.weatherapp.domain

import com.example.weatherapp.data.WeatherBody

data class Curr (

    val temp: Double,
    val feels_like: Double,
    val pressure: Int,
    val humidity: Int,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Int,
    val weatherBody: List<WeatherBody>
)
