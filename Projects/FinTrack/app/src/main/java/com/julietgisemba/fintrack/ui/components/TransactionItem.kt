package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.TransactionEntity

@Composable
fun TransactionItem(transactionEntity: TransactionEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Icon(transactionEntity.icon, contentDescription = "")
        Spacer(Modifier.width(20.dp))
        Column {
            Text(transactionEntity.title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text("${transactionEntity.date} - ${transactionEntity.category}", fontSize = 14.sp, fontWeight = FontWeight.Light)
        }
        Spacer(Modifier.weight(1f))
        Text("$${transactionEntity.amount}", fontSize = 16.sp, color = if (transactionEntity.isIncome) Color. Green else Color. Red, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.End)
    }
}