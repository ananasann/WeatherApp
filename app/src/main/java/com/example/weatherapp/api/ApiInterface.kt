package com.example.weatherapp.api


import com.example.weatherapp.domain.TmpI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("onecall?units=metric&exclude=minutely,alerts,hourly&appid=aeb2c4ec904689a4d7ad4fc531065e73")
    fun getWeatherForSomeCity(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
        ): Call<TmpI>
}