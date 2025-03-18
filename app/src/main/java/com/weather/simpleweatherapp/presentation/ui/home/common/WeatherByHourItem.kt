package com.weather.simpleweatherapp.presentation.ui.home.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.simpleweatherapp.R

@Composable
fun WeatherByHourItem() {

    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(top = 15.dp),
        contentAlignment = Alignment.BottomCenter,

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "오후 8시",
                fontSize = 12.sp
            )

            Image(
                painter = painterResource(R.drawable.ic_sun),
                contentDescription = null
            )

            Text(text = " 4°")
        }
    }
}