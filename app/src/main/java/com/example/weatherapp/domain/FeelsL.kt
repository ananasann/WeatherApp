package com.example.weatherapp.domain

import com.google.gson.annotations.SerializedName

data class FeelsL (
    val day : Double,
    val night : Double,
    val eve : Double,
    val morn : Double
)