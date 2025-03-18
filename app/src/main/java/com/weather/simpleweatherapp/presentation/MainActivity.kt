package com.weather.simpleweatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.weather.simpleweatherapp.presentation.navigation.AppNavigator
import com.weather.simpleweatherapp.presentation.navigation.LocalNavigator
import com.weather.simpleweatherapp.presentation.navigation.NavigationGraph
import com.weather.simpleweatherapp.presentation.ui.theme.SimpleWeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleWeatherAppTheme {
                // Jetpack Compose의 화면 간 네비게이션을 담당하는 컨트롤러 생성
                val navController = rememberNavController()

                // navController를 이용하여 화면 전환 로직을 처리하는 Navigator 객체 생성
                // remember를 통해 navController가 변경되지 않으면 같은 인스턴스 유지
                val appNavigator = remember(navController) { AppNavigator(navController) }

                // CompositionLocalProvider를 사용해 AppNavigator를 전역에서 접근 가능하게 제공
                // 이 범위 안의 Composable들은 어디서나 LocalNavigator.current를 통해 AppNavigator에 접근 가능
                CompositionLocalProvider(LocalNavigator provides appNavigator) {
                    // 생성한 navController를 NavigationGraph에 전달하여
                    // 앱의 실제 화면 흐름과 화면 전환을 구성
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}