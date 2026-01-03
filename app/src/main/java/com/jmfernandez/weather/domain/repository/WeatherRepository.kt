package com.jmfernandez.weather.domain.repository

import com.jmfernandez.weather.domain.model.WeatherInfo
import com.jmfernandez.weather.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}