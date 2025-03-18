package com.weather.simpleweatherapp.presentation.navigation

import androidx.navigation.NavHostController

class AppNavigator(private val navController: NavHostController) {

    // 화면 이동
    fun navigateTo(route: String) {
        navController.navigate(route)
    }

    // 스택 제거
    fun navigateBack() {
        navController.popBackStack()
    }

    // 모든 스택 제거
    fun navigateClearStack(route: String) {
        navController.navigate(route) {
            popUpTo(0) { inclusive = true }
        }
    }

    // 현재 활성화된 라우트 반환
    fun currentRoute(): String? {
        return navController.currentBackStackEntry?.destination?.route
    }
}
