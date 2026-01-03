package com.jmfernandez.weather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("hourly")
    val weatherData: WeatherDataDto,
    @SerializedName("daily")
    val weatherDailyData: WeatherDailyDto
)
