package com.julietgisemba.fintrack.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.julietgisemba.fintrack.data.dao.BudgetDao
import com.julietgisemba.fintrack.data.dao.GoalDao
import com.julietgisemba.fintrack.data.dao.TransactionDao
import com.julietgisemba.fintrack.model.Budget
import com.julietgisemba.fintrack.model.Goal
import com.julietgisemba.fintrack.model.TransactionEntity
import com.julietgisemba.fintrack.room.Converters

@Database(entities = [TransactionEntity::class, Budget::class, Goal::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class FinanceDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun budgetDao(): BudgetDao
    abstract fun goalDao(): GoalDao
}