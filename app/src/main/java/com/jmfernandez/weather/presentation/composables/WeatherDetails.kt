package com.jmfernandez.weather.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jmfernandez.weather.R
import com.jmfernandez.weather.presentation.WeatherState
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Composable
fun WeatherDetails(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Detalles del clima", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Column(
                   verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DetailItem(
                        title = "Viento",
                        value = "${data.windSpeed.roundToInt()} km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind)
                    )
                    DetailItem(
                        title = "Precipitación",
                        value = "${data.precipitation.roundToInt()} mm",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_rainy)
                    )
                    DetailItem(
                        title = "Amanecer",
                        value = data.sunrise.format(DateTimeFormatter.ofPattern("HH:mm")),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_sunrise)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DetailItem(
                        title = "Índice UV",
                        value = data.uvIndex.roundToInt().toString(),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_uv_index)
                    )
                    DetailItem(
                        title = "Humedad",
                        value = "${data.humidity.roundToInt()} %",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop)
                    )
                    DetailItem(
                        title = "Atardecer",
                        value = data.sunset.format(DateTimeFormatter.ofPattern("HH:mm")),
                        icon = ImageVector.vectorResource(id = R.drawable.ic_sunset)
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailItem(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(30.dp),
            tint = Color.Black
        )
        Spacer(Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = title, color = Color.Gray)
            Spacer(Modifier.height(4.dp))
            Text(text = value, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
        }
    }
}
