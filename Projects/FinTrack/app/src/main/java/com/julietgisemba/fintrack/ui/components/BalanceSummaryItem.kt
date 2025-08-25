package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun BalanceSummaryItem(label: String, value: Double) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = label,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
        Text(
            text = "$${String.format("%.2f", value)}",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}