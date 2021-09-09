package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

data class TempBody (
	@SerializedName("day")
		val day : Double,
	@SerializedName("min")
		val min : Double,
	@SerializedName("max")
		val max : Double,
	@SerializedName("night")
		val night : Double,
	@SerializedName("eve")
		val eve : Double,
	@SerializedName("morn")
		val morn : Double
)