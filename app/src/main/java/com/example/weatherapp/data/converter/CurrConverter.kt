package com.example.weatherapp.data.converter

import com.example.weatherapp.data.CurrTempInfo
import com.example.weatherapp.domain.Curr
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object CurrConverter : JsonDeserializer<Curr> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Curr {

        val body: CurrTempInfo =
            json?.let { context?.deserializeTypedRequired(it) }
                ?: throw Exception()

        return Curr(
            temp = body.temp,
            feels_like = body.feels_like,
            pressure = body.pressure,
            humidity = body.humidity,
            clouds = body.clouds,
            visibility = body.visibility,
            wind_speed = body.wind_speed,
            weatherBody = body.weatherBody

        )
    }
}