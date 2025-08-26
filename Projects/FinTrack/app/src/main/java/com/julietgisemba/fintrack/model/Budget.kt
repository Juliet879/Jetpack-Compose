package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector
import java.time.LocalDate

data class Budget(
    val categoryName: String,
    val spent: Double,
    val limit: Double,
    val icon: ImageVector,
    val type: BudgetType,
    val startDate: LocalDate? = null, // for upcoming
    val endDate: LocalDate? = null,   // for upcoming
    val isRecurring: Boolean = false
)


enum class BudgetType {
    UPCOMING,
    FIXED
}