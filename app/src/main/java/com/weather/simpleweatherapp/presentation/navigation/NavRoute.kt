package com.weather.simpleweatherapp.presentation.navigation



sealed class NavRoute(
    val route: String
) {
    // 스플래쉬
    object Splash : NavRoute("splash")

    // 홈
    object Home : NavRoute("home")
}
