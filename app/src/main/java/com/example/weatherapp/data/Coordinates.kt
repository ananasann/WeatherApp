package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
) {
    companion object {
        val Moscow = Coordinates(
            lat = 55.4367,
            lon = 37.4996
        )
    }
}