package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.ProfileOverview

@Composable
fun ProfileItemView(itemOverview: ProfileOverview, isFinanceOverview: Boolean) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(0.1.dp, Color.Gray),
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(itemOverview.icon, contentDescription = "")
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(itemOverview.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(itemOverview.subtitle, fontSize = 14.sp, color = Color.DarkGray)
            }

            if (isFinanceOverview) {
                itemOverview.amount?.let { Text(it, fontWeight = FontWeight.Bold, fontSize = 18.sp) }
            } else {
                if (itemOverview.moreInfoIcon != null) {
                    Icon(itemOverview.moreInfoIcon, contentDescription = "")
                }
            }
        }
    }
}