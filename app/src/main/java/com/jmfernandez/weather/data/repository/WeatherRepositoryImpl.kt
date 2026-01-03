package com.jmfernandez.weather.data.repository

import com.jmfernandez.weather.data.mappers.toWeatherInfo
import com.jmfernandez.weather.data.remote.api.WeatherApi
import com.jmfernandez.weather.domain.model.WeatherInfo
import com.jmfernandez.weather.domain.repository.WeatherRepository
import com.jmfernandez.weather.domain.util.Resource

class WeatherRepositoryImpl(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}