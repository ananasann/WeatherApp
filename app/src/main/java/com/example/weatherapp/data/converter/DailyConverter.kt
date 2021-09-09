package com.example.weatherapp.data.converter

import com.example.weatherapp.data.DailyBody
import com.example.weatherapp.domain.Daily
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object DailyConverter : JsonDeserializer<Daily> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Daily {
        val body: DailyBody =
            context?.deserialize<DailyBody>(json, typeOfT)
                ?: throw Exception()

        return Daily(
            clouds = body.clouds,
            rain = body.rain,
            tempBody = body.tempBody,
            humidity = body.humidity,
            feels_like = body.feels_like,
            weatherBody = body.weatherBody
        )
    }
}