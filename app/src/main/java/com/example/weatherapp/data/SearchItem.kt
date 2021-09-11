package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

data class SearchItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("coord")
    val coordinates: Coordinates
)