package com.julietgisemba.smartsaving.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction")
data class SavingTransaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val week: Int,
    val amount: Double
)
