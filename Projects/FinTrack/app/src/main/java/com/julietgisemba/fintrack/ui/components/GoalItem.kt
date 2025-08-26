package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julietgisemba.fintrack.model.Goal
import kotlin.math.roundToInt

@Composable
fun GoalItem(
    goal: Goal,
    icon: ImageVector? = null,
    showActions: Boolean = false, // Show buttons like Add Money / Plan
    compact: Boolean = false,     // For dashboard use
    onAddMoneyClick: (() -> Unit)? = null,
    onPlanClick: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (icon != null) {
                Icon(icon, contentDescription = "")
            }
            Column {
                Text(
                    goal.title,
                    fontSize = if (compact) 14.sp else 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    "$${goal.saved.roundToInt()} of $${goal.target.roundToInt()}",
                    fontSize = if (compact) 12.sp else 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                "${((goal.saved / goal.target) * 100).roundToInt()}%",
                fontSize = if (compact) 12.sp else 14.sp,
                fontWeight = FontWeight.Light
            )
        }
        Spacer(Modifier.height(10.dp))
        LinearProgressIndicator(
            progress = { (goal.saved / goal.target).toFloat() },
            color = Color(0xFF2C8A5B),
            trackColor = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(50))
                .padding(15.dp, 0.dp),
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
        )

        if (showActions) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ActionButton(text = "Add money", onClick = { onAddMoneyClick?.invoke() })
                ActionButton(text = "Plan", onClick = { onPlanClick?.invoke() })
            }
        }
    }
}

@Composable
fun ActionButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(150.dp)
            .padding(horizontal = 4.dp)
    ) {
        Text(text)
    }
}
