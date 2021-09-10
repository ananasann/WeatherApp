package com.example.weatherapp.data.converter

import com.example.weatherapp.data.WeatherBody
import com.example.weatherapp.domain.Weather
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.Exception
import java.lang.reflect.Type

object WeatherConverter:JsonDeserializer<Weather> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Weather {
        val body: WeatherBody =
            json?.let { context?.deserializeTypedRequired(it) }
                ?: throw Exception()
        return Weather(
            id = body.id,
            main = body.main,
            description = body.description,
            icon = body.icon
        )
    }
}