package com.julietgisemba.fintrack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.julietgisemba.fintrack.model.Transaction
import com.julietgisemba.fintrack.ui.components.BalanceSummaryItem
import com.julietgisemba.fintrack.ui.components.TransactionItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Transactions", fontWeight = FontWeight.Bold
                    )
                },
                actions = {
                    Button(
                        onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF2C8A5B))
                    ) {
                        Text("+ Add")
                    }
                },
            )
        }, containerColor = Color(0x54EFFBF6)
    ) { innerPadding ->

        var selectedFilter by remember { mutableStateOf("All") }
        val transactions = listOf(
            Transaction(
                "Groceries", "Aug 18", "Food", Icons.Default.ShoppingCart, -54.20, isIncome = false
            ), Transaction(
                "Salary", "Aug 15", "Income", Icons.Default.DateRange, 2800.00, isIncome = true
            ), Transaction(
                "Transport", "Aug 14", "Commute", Icons.Default.ThumbUp, -18.60, isIncome = false
            ), Transaction(
                "Freelance", "Aug 10", "Income", Icons.Default.DateRange, 500.00, isIncome = true
            ), Transaction(
                "Electricity", "Aug 09", "Utilities", Icons.Default.Place, -120.50, isIncome = false
            )
        )
        val filteredTransaction = when (selectedFilter) {
            "Income" -> transactions.filter { it.type == "Income" }
            "Expense" -> transactions.filter { it.type == "Expense" }
            else -> transactions
        }
        val totalIncome = transactions.filter { it.isIncome }.sumOf() { it.amount }
        val totalExpense = transactions.filter { !it.isIncome }.sumOf() { it.amount }
        val totalNet = totalIncome + totalExpense


        Column(
            modifier = Modifier
                .padding(15.dp, 0.dp)
                .padding(innerPadding)
        ) {
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {
                CustomFilterChip(
                    label = "All",
                    selected = selectedFilter == "All",
                    onClick = { selectedFilter = "All" },
                    Icons.Default.Menu
                )
                CustomFilterChip(
                    "Income",
                    selected = selectedFilter == "Income",
                    onClick = { selectedFilter = "Income" },
                    Icons.Default.ArrowForward
                )
                CustomFilterChip(
                    "Expense",
                    selected = selectedFilter == "Expense",
                    onClick = { selectedFilter = "Expense" },
                    Icons.Default.ArrowBack
                )
            }
            Spacer(Modifier.height(20.dp))

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
                    BalanceSummaryItem("Income", totalIncome)
                    BalanceSummaryItem("Expense", totalExpense)
                    BalanceSummaryItem("Net", totalNet)
                }
            }


            Spacer(Modifier.height(20.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                LazyColumn {
                    filteredTransaction.groupBy { it.date }.forEach { (date, items) ->
                        item {
                            Text(
                                text = date,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.padding(8.dp)
                            )
//                            Divider()
                        }
                        items(items) { transaction ->
                            TransactionItem(transaction)
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun CustomFilterChip(
    label: String, selected: Boolean, onClick: () -> Unit, icon: ImageVector
) {
    Surface(
        onClick = onClick,
        color = if (selected) Color.LightGray else Color.Transparent,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .width(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)
        ) {
            Icon(icon, contentDescription = "", modifier = Modifier.size(15.dp))
            Spacer(Modifier.width(5.dp))
            Text(
                text = label,
            )
        }

    }
}

@Composable
fun BalanceSection() {
}