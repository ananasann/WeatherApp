package com.example.weatherapp.domain

import com.example.weatherapp.data.FeelsLike
import com.example.weatherapp.data.TempBody
import com.example.weatherapp.data.WeatherBody

data class Daily(
    val dt : Int,
    val tempBody: TempBody,
    val weatherBody: List<WeatherBody>
)
