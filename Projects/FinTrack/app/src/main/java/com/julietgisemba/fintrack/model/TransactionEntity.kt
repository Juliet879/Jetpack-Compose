package com.julietgisemba.fintrack.model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.julietgisemba.fintrack.ui.components.CategoryIconMapper
import java.util.Date

@Entity(tableName = "transactions")
data class TransactionEntity(
    val title: String,            // e.g., "Groceries", "Salary"
    val date: Date,               // stored as Date
    val category: String,         // e.g., "Food", "Income"
    val amount: Double,           // e.g., -54.20
    val isIncome: Boolean,        // true = income, false = expense
    val type: TransactionType,
    val note: String? = null,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    ) {
    // Derived property for UI (not stored in DB)
    @Ignore
    val icon: ImageVector = CategoryIconMapper.getIcon(category)
}


enum class TransactionType { INCOME, EXPENSE }
