package com.julietgisemba.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.julietgisemba.movieapp.navigation.home.HomeScreen
import com.julietgisemba.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {

        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})) {
            backStackEntry -> //a variable that holds the data we are trying to pass to the screen
            DetailsScreen(
                navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}