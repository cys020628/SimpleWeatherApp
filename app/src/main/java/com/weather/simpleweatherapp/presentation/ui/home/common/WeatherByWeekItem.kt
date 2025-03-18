package com.weather.simpleweatherapp.presentation.ui.home.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.simpleweatherapp.R

@Composable
fun WeatherByWeekItem(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween, // 양 끝과 중앙 배치
        verticalAlignment = Alignment.CenterVertically // 세로 중앙 정렬
    ) {
        Text(
            text = "오늘.03.18", color = Color.White,
            fontSize = 12.sp
        )

        Image(painter = painterResource(R.drawable.ic_sun), contentDescription = null)
        Text(
            text = "최고 5° 최소0°", color = Color.White,
            fontSize = 12.sp
        )
    }
}