package com.example.weatherapp.data.converter

import com.example.weatherapp.data.TempInfo
import com.example.weatherapp.domain.TmpI
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

object TempInfoConverter : JsonDeserializer<TmpI> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TmpI {
        val body: TempInfo =
            json?.let { context?.deserializeTypedRequired(it) }
                ?: throw Exception()
        return TmpI(
            lat = body.lat,
            lon = body.lon,
            timezone = body.timezone,
            current = body.current,
            daily = body.daily
        )
    }

}