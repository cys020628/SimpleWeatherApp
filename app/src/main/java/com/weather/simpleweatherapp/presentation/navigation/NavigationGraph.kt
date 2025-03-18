package com.weather.simpleweatherapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.weather.simpleweatherapp.presentation.ui.splash.SplashScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController, startDestination = NavRoute.Splash.route
    ) {

        // 스플래쉬
        composable(NavRoute.Splash.route) {
            SplashScreen()
        }

        // 홈
        composable(NavRoute.Home.route) {

        }
    }
}


//@Composable
//fun NavigationGrap2h(navController: NavHostController) {
//    NavHost(navController, startDestination = NavRoute.Home.route) {
//        composable(NavRoute.Home.route) {
//            HomeScreen(
//                onNavigateToDetail = { itemId ->
//                    navController.navigate(NavRoute.Detail.createRoute(itemId))
//                },
//                onNavigateToSettings = {
//                    navController.navigate(NavRoute.Settings.route)
//                }
//            )
//        }
//
//        composable(
//            route = NavRoute.Detail.route,
//            arguments = listOf(navArgument("itemId") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
//            DetailScreen(itemId = itemId, navController = navController)
//        }
//
//        composable(NavRoute.Settings.route) {
//            SettingsScreen(navController = navController)
//        }
//    }
//}
