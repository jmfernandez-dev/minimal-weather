package com.jmfernandez.weather.data.mappers

import com.jmfernandez.weather.data.remote.dto.WeatherDataDto
import com.jmfernandez.weather.data.remote.dto.WeatherDto
import com.jmfernandez.weather.domain.model.WeatherData
import com.jmfernandez.weather.domain.model.WeatherInfo
import com.jmfernandez.weather.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(weatherDto: WeatherDto): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        val precipitation = precipitation[index]
        val dailyIndex = index / 24
        val sunrise = weatherDto.weatherDailyData.sunrise[dailyIndex]
        val sunset = weatherDto.weatherDailyData.sunset[dailyIndex]
        val uvIndex = weatherDto.weatherDailyData.uvIndex[dailyIndex]

        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode),
                precipitation = precipitation,
                sunrise = LocalDateTime.parse(sunrise, DateTimeFormatter.ISO_DATE_TIME),
                sunset = LocalDateTime.parse(sunset, DateTimeFormatter.ISO_DATE_TIME),
                uvIndex = uvIndex
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap(this)
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        it.time.hour == now.hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}