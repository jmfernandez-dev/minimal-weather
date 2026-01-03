package com.jmfernandez.weather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherDailyDto(
    @SerializedName("sunrise")
    val sunrise: List<String>,
    @SerializedName("sunset")
    val sunset: List<String>,
    @SerializedName("uv_index_max")
    val uvIndex: List<Double>
)
