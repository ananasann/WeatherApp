package com.example.weatherapp.data.converter

import com.example.weatherapp.data.TempBody
import com.example.weatherapp.domain.Temp
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object TempBodyConverter:JsonDeserializer<Temp> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Temp {
        val body: TempBody =
            context?.deserialize<TempBody>(json, typeOfT)
            ?: throw Exception()
        return Temp(
            day = body.day,
            min = body.min,
            max = body.max,
            night = body.night,
            eve = body.eve,
            morn = body.morn
        )
    }
}