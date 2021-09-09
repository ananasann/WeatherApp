package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

data class TempInfo (

	@SerializedName("lat")
		val lat : Double,
	@SerializedName("lon")
		val lon : Double,
	@SerializedName("timezone")
		val timezone : String,
	@SerializedName("timezone_offset")
		val timezone_offset : Int,
	@SerializedName("current")
		val current : CurrTempInfo,
	@SerializedName("hourly")
		val hourly : List<HourlyBody>,
	@SerializedName("daily")
		val daily : List<DailyBody>
)