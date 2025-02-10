package com.julietgisemba.smartsaving.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.julietgisemba.smartsaving.model.SavingTransaction
import com.julietgisemba.smartsaving.utils.DateConverter

@Database(entities = [SavingTransaction::class], version = 8, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class SavingTransactionDatabase: RoomDatabase() {
    abstract fun savingTransactionDao(): SavingTransactionDao
}