package com.weather.simpleweatherapp.presentation.navigation

import androidx.compose.runtime.staticCompositionLocalOf

// CompositionLocal을 생성하여 AppNavigator를 전역적으로 제공하기 위한 정의
val LocalNavigator = staticCompositionLocalOf<AppNavigator> {
    error("Navigator not provided") // Navigator가 제공되지 않은 상태에서 접근 시 예외 발생
}