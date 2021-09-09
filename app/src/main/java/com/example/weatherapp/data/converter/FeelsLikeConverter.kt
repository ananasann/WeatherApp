package com.example.weatherapp.data.converter

import com.example.weatherapp.data.FeelsLike
import com.example.weatherapp.domain.FeelsL
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object FeelsLikeConverter:JsonDeserializer<FeelsL> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): FeelsL {
        val body: FeelsLike =
            context?.deserialize<FeelsLike>(json, typeOfT)
                ?: throw Exception()
        return FeelsL(
            day = body.day,
            eve = body.eve,
            morn = body.morn,
            night = body.night
        )
    }
}