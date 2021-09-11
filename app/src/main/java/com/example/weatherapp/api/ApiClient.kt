package com.example.weatherapp.api

import com.example.weatherapp.data.converter.*
import com.example.weatherapp.domain.*
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var retrofit: Retrofit? = null
    private val baseUrl: String = "https://api.openweathermap.org/data/2.5/"
    //lat=55.45&lon=37.36&units=metric&exclude=minutely,alerts&appid=aeb2c4ec904689a4d7ad4fc531065e73"

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(getBuilder().create()))
                .build()
        }
        return retrofit!!
    }

    private fun getBuilder(): GsonBuilder {
        val builder = GsonBuilder()
        builder.registerTypeAdapter(Daily::class.java, DailyConverter)
        builder.registerTypeAdapter(Curr::class.java, CurrConverter)
        builder.registerTypeAdapter(FeelsL::class.java, FeelsLikeConverter)
        builder.registerTypeAdapter(TmpI::class.java, TempInfoConverter)
        builder.registerTypeAdapter(Temp::class.java, TempBodyConverter)
        builder.registerTypeAdapter(Weather::class.java, WeatherConverter)
        return builder

    }
}