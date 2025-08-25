package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BudgetItem(
    icon: ImageVector,
    categoryName: String,
    amountSpent: String,
    budgetLimit: String,
    progress: Float,
    compact: Boolean = true, // true = dashboard, false = detailed
    remainingAmount: String? = null, // null = dashboard, non-null = detailed
    onClick: () -> Unit = {},
    percentage: String? = null,
    showIconBackground: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = if (compact) 8.dp else 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon
        Box(
            modifier = Modifier
                .size(if (compact) 36.dp else 44.dp)
                .background(
                    color = Color.Transparent,
                    shape = RectangleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = categoryName,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = categoryName,
                style = if (compact) MaterialTheme.typography.bodyMedium else MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "$amountSpent of $budgetLimit",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .then(if (compact) Modifier.width(120.dp) else Modifier.fillMaxWidth())
                    .height(if (compact) 6.dp else 8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                color = Color(0xFF2C8A5B),
                trackColor = Color.LightGray,
            )
        }

        // Right-side Remaining info (only in detailed mode)
        if (!compact && remainingAmount != null) {
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = remainingAmount,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = if (remainingAmount.startsWith("-")) Color.Red else MaterialTheme.colorScheme.primary
            )
        }
    }
}
