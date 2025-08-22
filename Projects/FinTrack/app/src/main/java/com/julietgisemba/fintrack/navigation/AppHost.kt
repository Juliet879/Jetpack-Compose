package com.julietgisemba.fintrack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.julietgisemba.fintrack.ui.screens.BudgetsScreen
import com.julietgisemba.fintrack.ui.screens.DashboardScreen
import com.julietgisemba.fintrack.ui.screens.GoalsScreen
import com.julietgisemba.fintrack.ui.screens.ProfileScreen
import com.julietgisemba.fintrack.ui.screens.TransactionsScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = Destinations.Dashboard.route, modifier = modifier) {
        composable(Destinations.Dashboard.route) { DashboardScreen() }
        composable(Destinations.Transactions.route) { TransactionsScreen() }
        composable(Destinations.Budgets.route) { BudgetsScreen() }
        composable(Destinations.Goals.route) { GoalsScreen() }
        composable(Destinations.Profile.route) { ProfileScreen() }
    }

}