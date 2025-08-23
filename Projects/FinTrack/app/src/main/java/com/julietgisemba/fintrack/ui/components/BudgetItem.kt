package com.julietgisemba.fintrack.ui.components

import android.R.attr.progress
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.Budget

@Composable
fun BudgetItem (budget: Budget){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Icon(budget.icon, contentDescription = "")
        Spacer(Modifier.width(20.dp))
        Column {
            Text(budget.title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text("${budget.spent} of ${budget.limit}", fontSize = 14.sp, fontWeight = FontWeight.Light)
        }
        Spacer(Modifier.weight(1f))
        LinearProgressIndicator(
            progress = { (budget.spent / budget.limit).toFloat() },
            color = Color(0xFF2C8A5B),
            trackColor = Color.LightGray,
            modifier = Modifier
                .width(100.dp)
                .height(8.dp)
                .clip(RoundedCornerShape(50)),
                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
            )
    }
}