package com.julietgisemba.smartsaving.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.julietgisemba.smartsaving.utils.DateConverter
import java.time.LocalDate

@Entity(tableName = "saving_transaction")
data class SavingTransaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val week: Int = 0,
    val amount: Double = 0.0,
    val startDate: LocalDate = LocalDate.now()
)
