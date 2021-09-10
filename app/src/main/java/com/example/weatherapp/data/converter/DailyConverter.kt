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
            json?.let { context?.deserializeTypedRequired(it) }
                ?: throw Exception()

        return Daily(
            dt = body.dt,
            tempBody = body.tempBody,
            weatherBody = body.weatherBody
        )
    }
}