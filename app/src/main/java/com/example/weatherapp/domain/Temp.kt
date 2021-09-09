package com.example.weatherapp.domain

import com.google.gson.annotations.SerializedName

data class Temp(
    val day : Double,
    val min : Double,
    val max : Double,
    val night : Double,
    val eve : Double,
    val morn : Double
)
