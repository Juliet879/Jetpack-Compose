package com.julietgisemba.fintrack.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
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
import com.julietgisemba.fintrack.model.Goal
import com.julietgisemba.fintrack.ui.components.GoalItem
import com.julietgisemba.fintrack.ui.components.QuickAddController
import java.text.SimpleDateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalsScreen() {
    val goals = listOf(
        Goal(
            title = "Vacation to Bali",
            saved = 500.0,
            target = 1500.0,
            deadline = SimpleDateFormat("yyyy-MM-dd").parse("2025-12-31"),
            isActive = true
        ),
        Goal(
            title = "New Laptop",
            saved = 800.0,
            target = 2000.0,
            deadline = SimpleDateFormat("yyyy-MM-dd").parse("2025-11-30"),
            isActive = true
        ),
        Goal(
            title = "Emergency Fund",
            saved = 1200.0,
            target = 5000.0,
            deadline = SimpleDateFormat("yyyy-MM-dd").parse("2026-09-01"),
            isActive = true
        ),
        Goal(
            title = "Car Down Payment",
            saved = 2500.0,
            target = 10000.0,
            deadline = SimpleDateFormat("yyyy-MM-dd").parse("2026-05-01"),
            isActive = true
        )
    )


    val emergencyFund = Goal("Emergency Fund", saved = 3600.0, target = 5000.0)

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Goals", fontWeight = FontWeight.Bold
                )
            }, actions = {
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF2C8A5B))
                ) {
                    Text("+ New goal")
                }
            })
        }, containerColor = Color(0x54EFFBF6),
        floatingActionButton = {

        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(15.dp, 0.dp).padding(innerPadding)) {
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.4.dp, Color.Gray),
                modifier = Modifier
            ) {
                    GoalItem(goal =  emergencyFund, icon = Icons.Default.DateRange, showActions = true)
            }

            Spacer(Modifier.height(20.dp))

            Text("Active goals", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(0.3.dp, Color.Gray),
                modifier = Modifier
            ) {
                LazyColumn {
                    items(goals) { goal ->
                        GoalItem(
                            goal = goal,
                            icon = Icons.Default.DateRange)

                    }
                }
            }
        }
    }
}