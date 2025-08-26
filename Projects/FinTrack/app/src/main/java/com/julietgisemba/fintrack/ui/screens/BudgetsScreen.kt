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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
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
import com.julietgisemba.fintrack.model.BudgetType
import com.julietgisemba.fintrack.ui.components.BalanceSummaryItem
import com.julietgisemba.fintrack.ui.components.BudgetItem
import java. time.LocalDate
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetsScreen() {
    val budgets = listOf(
        Budget(
            icon = Icons.Default.ShoppingCart,
            categoryName = "Groceries",
            spent = 150.0,
            limit = 300.0,
            type = BudgetType.UPCOMING,
            isRecurring = true
        ),
        Budget(
            icon = Icons.Default.Home,
            categoryName = "Rent",
            spent = 500.0,
            limit = 500.0,
            type = BudgetType.FIXED,
            isRecurring = true
        ),
        Budget(
            icon = Icons.Default.LocationOn,
            categoryName = "Vacation",
            spent = 0.0,
            limit = 1200.0,
            type = BudgetType.UPCOMING,
            startDate = LocalDate.of(2025, 9, 1),
            endDate = LocalDate.of(2025, 9, 15)
        ),
        Budget(
            icon = Icons.Default.ThumbUp,
            categoryName = "Dining Out",
            spent = 50.0,
            limit = 200.0,
            type = BudgetType.UPCOMING
        )
    )

    val fixedBudgets = budgets.filter { it.type == BudgetType.FIXED }
    val upcomingBudgets = budgets.filter { it.type == BudgetType.UPCOMING }

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
                    items(upcomingBudgets) { budget ->
                        BudgetItem(
                            budget.icon,
                            budget.categoryName,
                            budget.spent,
                            budget.limit,
                            (budget.spent / budget.limit).toFloat(),
                            false,
                            "$${(budget.limit - budget.spent).roundToInt()} left",

                            )
                    }
                }
            }
            Spacer(Modifier.height(20.dp))

            Text("Fixed Budget", fontSize = 20.sp, fontWeight = FontWeight.Medium)

            Spacer(Modifier.height(20.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                LazyColumn(modifier = Modifier.padding(12.dp)) {
                    items(fixedBudgets) { budget ->
                        BudgetItem(
                            budget.icon,
                            budget.categoryName,
                            budget.spent,
                            budget.limit,
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