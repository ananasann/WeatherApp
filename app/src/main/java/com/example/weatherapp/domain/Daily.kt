package com.example.weatherapp.domain

import com.example.weatherapp.data.FeelsLike
import com.example.weatherapp.data.TempBody
import com.example.weatherapp.data.WeatherBody

data class Daily(
    val tempBody: TempBody,
    val feels_like: FeelsLike,
    val humidity: Int,
    val weatherBody: List<WeatherBody>,
    val clouds: Int,
    val rain: Double
)
