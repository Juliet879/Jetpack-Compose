package com.julietgisemba.smartsaving.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.julietgisemba.smartsaving.model.SavingTransaction

@Database(entities = [SavingTransaction::class], version = 2, exportSchema = false)
abstract class SavingTransactionDatabase: RoomDatabase() {
    abstract fun savingTransactionDao(): SavingTransactionDao
}