package com.jmfernandez.weather.domain.model

import androidx.annotation.DrawableRes
import com.jmfernandez.weather.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType("Cielo despejado", R.drawable.ic_sunny)
    object MainlyClear : WeatherType("Mayormente despejado", R.drawable.ic_cloudy)
    object PartlysCloudy : WeatherType("Parcialmente nublado", R.drawable.ic_cloudy)
    object Overcast : WeatherType("Nublado", R.drawable.ic_cloudy)
    object Foggy : WeatherType("Niebla", R.drawable.ic_very_cloudy)
    object DepositingRimeFog : WeatherType("Niebla engelante", R.drawable.ic_very_cloudy)
    object LightDrizzle : WeatherType("Llovizna ligera", R.drawable.ic_rainshower)
    object ModerateDrizzle : WeatherType("Llovizna moderada", R.drawable.ic_rainshower)
    object DenseDrizzle : WeatherType("Llovizna densa", R.drawable.ic_rainshower)
    object LightFreezingDrizzle : WeatherType("Llovizna helada ligera", R.drawable.ic_snowyrainy)
    object DenseFreezingDrizzle : WeatherType("Llovizna helada densa", R.drawable.ic_snowyrainy)
    object SlightRain : WeatherType("Lluvia ligera", R.drawable.ic_rainy)
    object ModerateRain : WeatherType("Lluvia moderada", R.drawable.ic_rainy)
    object HeavyRain : WeatherType("Lluvia intensa", R.drawable.ic_rainy)
    object HeavyFreezingRain: WeatherType("Lluvia helada intensa", R.drawable.ic_snowyrainy)
    object SlightSnowFall: WeatherType("Nevada ligera", R.drawable.ic_snowy)
    object ModerateSnowFall: WeatherType("Nevada moderada", R.drawable.ic_heavysnow)
    object HeavySnowFall: WeatherType("Nevada intensa", R.drawable.ic_heavysnow)
    object SnowGrains: WeatherType("Granos de nieve", R.drawable.ic_heavysnow)
    object SlightRainShowers: WeatherType("Chubascos ligeros", R.drawable.ic_rainshower)
    object ModerateRainShowers: WeatherType("Chubascos moderados", R.drawable.ic_rainshower)
    object ViolentRainShowers: WeatherType("Chubascos violentos", R.drawable.ic_rainshower)
    object SlightSnowShowers: WeatherType("Chubascos de nieve ligeros", R.drawable.ic_snowy)
    object HeavySnowShowers: WeatherType("Chubascos de nieve intensos", R.drawable.ic_snowy)
    object ModerateThunderstorm: WeatherType("Tormenta moderada", R.drawable.ic_thunder)
    object SlightHailThunderstorm: WeatherType("Tormenta con granizo ligero", R.drawable.ic_rainythunder)
    object HeavyHailThunderstorm: WeatherType("Tormenta con granizo intenso", R.drawable.ic_rainythunder)

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlysCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}
