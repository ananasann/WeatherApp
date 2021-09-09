package com.example.weatherapp.data.converter

import com.example.weatherapp.data.HourlyBody
import com.example.weatherapp.domain.Hourly
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object HourlyConverter:JsonDeserializer<Hourly> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Hourly {
        val body: HourlyBody =
            context?.deserialize<HourlyBody>(json,typeOfT)
                ?: throw Exception()
        return Hourly(
            dt = body.dt,
            feels_like = body.feels_like,
            temp = body.temp,
            weatherBody = body.weatherBody
        )
    }
}