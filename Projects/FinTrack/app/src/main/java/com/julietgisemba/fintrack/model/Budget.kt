package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Budget(
    val title: String,
    val spent: Double,
    val limit: Double,
    val icon: ImageVector
)