package com.julietgisemba.fintrack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.Budget
import com.julietgisemba.fintrack.model.BudgetType
import com.julietgisemba.fintrack.model.Goal
import com.julietgisemba.fintrack.model.Transaction
import com.julietgisemba.fintrack.ui.components.ActionButton
import com.julietgisemba.fintrack.ui.components.DashboardCard
import com.julietgisemba.fintrack.ui.components.GoalItem
import com.julietgisemba.fintrack.ui.components.TransactionItem
import com.julietgisemba.fintrack.ui.components.BudgetItem
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "FinTrack", fontWeight = FontWeight.Bold
                    )
                })
        }, containerColor = Color(0x54EFFBF6)
    ) { innerPadding ->

        val transactions = listOf(
            Transaction(
                "Groceries", "Aug 18", "Food", Icons.Default.ShoppingCart, -54.20, isIncome = false
            ), Transaction(
                "Salary", "Aug 15", "Income", Icons.Default.DateRange, 2800.00, isIncome = true
            ), Transaction(
                "Transport", "Aug 14", "Commute", Icons.Default.ThumbUp, -18.60, isIncome = false
            )
        )

        val budgets = listOf(
            Budget(
                icon = Icons.Default.ShoppingCart,
                categoryName = "Groceries",
                spent = 150.0,
                limit = 300.0,
                type = BudgetType.FIXED,
                isRecurring = true
            ), Budget(
                icon = Icons.Default.Home,
                categoryName = "Rent",
                spent = 500.0,
                limit = 500.0,
                type = BudgetType.FIXED,
                isRecurring = true
            ), Budget(
                icon = Icons.Default.LocationOn,
                categoryName = "Vacation",
                spent = 0.0,
                limit = 1200.0,
                type = BudgetType.UPCOMING,
                startDate = LocalDate.of(2025, 9, 1),
                endDate = LocalDate.of(2025, 9, 15)
            ), Budget(
                icon = Icons.Default.ThumbUp,
                categoryName = "Dining Out",
                spent = 50.0,
                limit = 200.0,
                type = BudgetType.FIXED
            )
        )

        val goals = listOf(
            Goal("Emergency Fund", saved = 3600.0, target = 5000.0),
            Goal("Vacation", saved = 1800.0, target = 3000.0)
        )

        Column(
            modifier = Modifier
                .padding(15.dp, 0.dp, 10.dp)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        "Search transactions, budgets, goals",
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") })
            Spacer(Modifier.height(10.dp))
            DashboardCard(
                totalBalance = 12480.50,
                income = 3200.0,
                spent = 2150.0,
                saved = 1050.0,
                progress = 0.62,
                goalText = "$6,200 / $10,000"
            )
            Spacer(Modifier.height(14.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                ActionButton(Icons.Default.ArrowForward, "Add Income")
                ActionButton(Icons.Default.ArrowBack, "Add Expense")
                ActionButton(Icons.Default.Build, "New Goal")
            }
            Spacer(Modifier.height(20.dp))

            Text("Recent transactions", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                Column {
                    transactions.take(3).forEach { transaction ->
                        TransactionItem(transaction)
                    }
                }
            }
            Spacer(Modifier.height(20.dp))

            Text("Budgets", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                Column {
                    budgets.take(3).forEach { budget ->
                        BudgetItem(
                            budget.icon,
                            budget.categoryName,
                            budget. spent,
                            budget.limit,
                            (budget.spent / budget.limit).toFloat()
                        )
                    }
                }
            }
            Spacer(Modifier.height(20.dp))

            Text("Goals", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                Column {
                    goals.take(3).forEach { goal ->
                        GoalItem(goal)
                    }
                }
            }
        }
    }
}