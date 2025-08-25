package com.julietgisemba.fintrack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import com.julietgisemba.fintrack.model.UpcomingExpense
import com.julietgisemba.fintrack.ui.components.BalanceSummaryItem
import com.julietgisemba.fintrack.ui.components.BudgetItem
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetsScreen() {
    val budgets = listOf(
        Budget("Groceries", 186.0, 300.0, Icons.Default.ShoppingCart),
        Budget("Transport", 40.0, 100.0, Icons.Default.Star),
        Budget("Dining Out", 156.0, 200.0, Icons.Default.CheckCircle),
        Budget("Utilities", 110.0, 200.0, Icons.Default.Build)
    )

    val upcomingExpenses = listOf(
        UpcomingExpense("Rent", "Due Sep 1", 1200.0),
        UpcomingExpense("Internet", "Due Aug 28", 60.0)
    )
    val planned = budgets.sumOf { it.limit }
    val spent = budgets.sumOf { it.spent }
    val remaining = planned - spent

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Budgets", fontWeight = FontWeight.Bold
                )
            }, actions = {
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF2C8A5B))
                ) {
                    Text("+ Add")
                }
            })
        }, containerColor = Color(0x54EFFBF6)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .padding(innerPadding)
        ) {
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(Modifier.height(10.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.4.dp, Color.Gray),
                modifier = Modifier
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    BalanceSummaryItem("Planned", planned)
                    BalanceSummaryItem("Spent", spent)
                    BalanceSummaryItem("Remaining", remaining)
                }
            }
            Spacer(Modifier.height(20.dp))

            Text("This month", fontSize = 20.sp, fontWeight = FontWeight.Medium)

            Spacer(Modifier.height(20.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                LazyColumn(modifier = Modifier.padding(12.dp)) {
                    items(budgets) { budget ->
                        BudgetItem(
                            budget.icon,
                            budget.title,
                            "$${budget.spent.roundToInt()} of",
                            "$${budget.limit.roundToInt()}",
                            (budget.spent / budget.limit).toFloat(),
                            false,
                            "$${(budget.limit - budget.spent).roundToInt()} left",

                            )
                    }
                }

            }

        }
    }
}