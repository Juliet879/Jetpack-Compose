package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Transaction (
    val title: String,
    val date: String,
    val category: String,
    val icon: ImageVector,
    val amount: Double,
    val isIncome: Boolean
)