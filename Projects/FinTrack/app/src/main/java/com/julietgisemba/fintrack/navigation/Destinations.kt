package com.julietgisemba.fintrack.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import org.chromium.base.Flag

sealed class Destinations(val route: String, val label: String, val icon: ImageVector) {
    object Dashboard: Destinations("dashboard", "Dashboard", Icons.Default.Home)
    object Transactions: Destinations("transactions", "Transactions", Icons.Default.List)
    object Budgets: Destinations("budgets", "Budgets", Icons.Default.DateRange)
    object Goals : Destinations("goals", "Goals", Icons.Default.Build)
    object Profile : Destinations("profile", "Profile", Icons.Default.Person)
}