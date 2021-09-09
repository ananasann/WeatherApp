package com.example.weatherapp.domain

import com.example.weatherapp.data.CurrTempInfo
import com.example.weatherapp.data.DailyBody
import com.example.weatherapp.data.HourlyBody

data class TmpI(
    val lat : Double,
    val lon : Double,
    val timezone : String,
    val current : CurrTempInfo,
    val hourly : List<HourlyBody>,
    val daily : List<DailyBody>
)
