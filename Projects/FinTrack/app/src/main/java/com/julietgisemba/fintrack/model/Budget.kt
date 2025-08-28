package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.julietgisemba.fintrack.ui.components.CategoryIconMapper
import java.util.Date

@Entity(tableName = "budgets")
data class Budget(
    val categoryName: String,
    val limit: Double,
    val spent: Double = 0.0,
    val type: BudgetType,        // FIXED, UPCOMING
    val isRecurring: Boolean = false,
    val startDate: Date? = null,
    val endDate: Date? = null,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    ) {
    @Ignore
    val icon: ImageVector = CategoryIconMapper.getIcon(categoryName)
}
enum class BudgetPeriod { WEEKLY, MONTHLY, YEARLY }
enum class BudgetType { FIXED, UPCOMING }
