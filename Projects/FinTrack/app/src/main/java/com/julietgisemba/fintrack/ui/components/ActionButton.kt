package com.julietgisemba.fintrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(icon: ImageVector, label: String) {
    Card {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(110.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))) {
            IconButton(onClick = { /* Handle click */ }) {
                Icon(icon, contentDescription = label, tint = Color(0xFF2C8A5B))
            }
            Text(label, fontSize = 14.sp)
        }
    }
}