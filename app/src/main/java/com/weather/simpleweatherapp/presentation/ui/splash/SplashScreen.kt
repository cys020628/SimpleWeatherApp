package com.weather.simpleweatherapp.presentation.ui.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavigatorProvider
import com.weather.simpleweatherapp.R
import com.weather.simpleweatherapp.presentation.navigation.currentNavigator
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun SplashScreen() {

    val navigator = currentNavigator()


    // 후에 날씨 데이터 및 위치 데이터 확인 및 다운로드 후 화면 이동 로직 작성
    LaunchedEffect(Unit) {
        delay(2000)
        Timber.e("이동")
    }

    // 무한 회전 애니메이션 정의
    val infiniteTransition = rememberInfiniteTransition()
    val rotation = infiniteTransition.animateFloat(
        initialValue = 0f, // 초기 각도
        targetValue = 360f, // 최종 각도
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 4000, easing = LinearEasing), // 4초 동안 1회전
            repeatMode = RepeatMode.Restart // 다시 0도로 돌아가서 반복
        )
    ).value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo 이미지",
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer(rotationZ = rotation),
            tint = Color.White
        )
    }
}