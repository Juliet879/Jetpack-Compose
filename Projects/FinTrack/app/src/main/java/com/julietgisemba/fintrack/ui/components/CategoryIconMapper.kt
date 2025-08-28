package com.julietgisemba.fintrack.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

object CategoryIconMapper {
    fun getIcon(category: String): ImageVector {
        return when (category.lowercase()) {
            "groceries" -> Icons.Default.ShoppingCart
            "rent" -> Icons.Default.Home
            "vacation" -> Icons.Default.LocationOn
            "dining out" -> Icons.Default.ThumbUp
            "income", "salary" -> Icons.Default.DateRange
            "transport" -> Icons.Default.Place
            else -> Icons.Default.Email
        }
    }
}
