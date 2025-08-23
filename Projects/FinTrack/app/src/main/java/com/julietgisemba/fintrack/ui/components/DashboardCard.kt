package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gen._net._android._net_java__assetres.srcjar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardCard(
    totalBalance: Double,
    income: Double,
    spent: Double,
    saved: Double,
    progress: Double,
    goalText: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFFBF6)),
        elevation = CardDefaults.elevatedCardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Total balance", fontSize = 14.sp, color = Color.Gray)
            Text(
                "$${String.format("%,.2f", totalBalance)}",
                fontSize = 28.sp, fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            )
            {
                InfoBox("This month income", income)
                InfoBox("This month spend", spent)
                InfoBox("Saved", saved)
            }
            Spacer(Modifier.height(15.dp))
            Text("Savings goal progress  62%", fontSize = 14.sp, color = Color.Gray)
            Spacer(Modifier.height(5.dp))
            LinearProgressIndicator(
            progress = { 0.62f },
            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(50)),
            color = Color(0xFF2C8A5B),
            trackColor = Color.LightGray,
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
            Spacer(Modifier.height(5.dp))
            Text("$6,200 / \$10,000", fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun InfoBox(label: String, amount: Double) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp)
            .fillMaxHeight()
    )
    {
        Text(label, fontSize = 14.sp, color = Color.Gray)
        Text("$${String.format("%,.2f", amount)}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}