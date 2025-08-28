package com.julietgisemba.fintrack.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.julietgisemba.fintrack.ui.components.QuickAddController
import com.julietgisemba.fintrack.ui.screens.BudgetsScreen
import com.julietgisemba.fintrack.ui.screens.DashboardScreen
import com.julietgisemba.fintrack.ui.screens.GoalsScreen
import com.julietgisemba.fintrack.ui.screens.ProfileScreen
import com.julietgisemba.fintrack.ui.screens.TransactionsScreen
import com.julietgisemba.fintrack.viewmodel.FinanceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier, viewModel: FinanceViewModel) {
    NavHost(navController = navController, startDestination = Destinations.Dashboard.route, modifier = modifier) {
        composable(Destinations.Dashboard.route) { DashboardScreen() }
        composable(Destinations.Transactions.route) { TransactionsScreen() }
        composable(Destinations.Budgets.route) { BudgetsScreen() }
        composable(Destinations.Goals.route) { GoalsScreen() }
        composable(Destinations.Profile.route) { ProfileScreen() }
    }

}