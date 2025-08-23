package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.julietgisemba.fintrack.model.Goal
import kotlin.math.roundToInt

@Composable
fun GoalItem (goal: Goal) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            
        ) {
            Text(goal.title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text("$${goal.saved} of ${goal.target}", fontSize = 14.sp)
        }
        Spacer(Modifier.weight(1f))
        Text("${((goal.saved / goal.target) * 100).roundToInt()}%",  fontSize = 14.sp, fontWeight = FontWeight.Light)

    }
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
}