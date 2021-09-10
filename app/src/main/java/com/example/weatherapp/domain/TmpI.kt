package com.example.weatherapp.domain

import com.example.weatherapp.data.CurrTempInfo
import com.example.weatherapp.data.DailyBody

data class TmpI(
    val lat : Double,
    val lon : Double,
    val timezone : String,
    val current : CurrTempInfo,
    val daily : List<DailyBody>
)
