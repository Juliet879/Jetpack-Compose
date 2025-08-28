package com.julietgisemba.fintrack.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incomes")
data class Income(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Double,
    val accountName: String,
    val balance: Double,
    val timestamp: Long
)