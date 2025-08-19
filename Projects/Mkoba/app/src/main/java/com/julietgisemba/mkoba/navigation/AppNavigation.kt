package com.julietgisemba.mkoba.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.julietgisemba.mkoba.screens.Login
import com.julietgisemba.mkoba.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.SplashScreen.name) {
        composable(AppScreen.SplashScreen.name) {
            SplashScreen(navController)
        }

        composable(AppScreen.Login.name) {
            Login()
        }
    }
}