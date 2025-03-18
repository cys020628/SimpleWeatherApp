package com.weather.simpleweatherapp.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.simpleweatherapp.R
import com.weather.simpleweatherapp.presentation.common.TopBarAction
import com.weather.simpleweatherapp.presentation.common.WeatherTopBar
import com.weather.simpleweatherapp.presentation.navigation.currentNavigator
import com.weather.simpleweatherapp.presentation.ui.home.common.WeatherByHourItem
import com.weather.simpleweatherapp.presentation.ui.home.common.WeatherByWeekItem
import timber.log.Timber

@Composable
fun HomeScreen(

) {
    val navigator = currentNavigator()

    Scaffold(
        topBar = {
            WeatherTopBar(
                navigationIconRes = R.drawable.ic_menu,
                actions = listOf(
                    TopBarAction(R.drawable.ic_location, "Location") {
                        Timber.e("위치 화면 이동")
                    }
                ),
                onNavigationClick = {
                    Timber.e("메뉴 화면 이동")
                }

            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

            // 위치 및 날씨 아이콘
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "구갈동",
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Image(
                        painter = painterResource(R.drawable.ic_sun),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "현재 온도 5°",
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "최저 1°",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "최고 10°",
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )
                    }
                }
            }

            // 시간별 날씨
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_time),
                    contentDescription = null
                )
                Text(
                    text = "시간별 예보",
                    modifier = Modifier.padding(start = 5.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp
                )
            }

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(10) { index ->
                    WeatherByHourItem()
                }
            }

            HorizontalDivider(
                color = Color.White,
                modifier = Modifier.padding(top = 30.dp),
                thickness = 0.5.dp
            )

            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_calendar),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "이번주 예보",
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp, max = 300.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(7) { index ->
                    WeatherByWeekItem()
                }
            }
        }
    }
}