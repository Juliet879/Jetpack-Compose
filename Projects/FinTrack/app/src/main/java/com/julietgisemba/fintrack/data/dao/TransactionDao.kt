package com.julietgisemba.fintrack.data.dao

import androidx.room.*
import com.julietgisemba.fintrack.model.Budget
import com.julietgisemba.fintrack.model.Goal
import com.julietgisemba.fintrack.model.TransactionEntity

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    suspend fun getAllTransactions(): List<TransactionEntity>
}

@Dao
interface BudgetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudget(budget: Budget)

    @Query("UPDATE budgets SET spent = spent + :amount WHERE categoryName = :category")
    suspend fun updateBudgetSpent(category: String, amount: Double)

    @Query("SELECT * FROM budgets")
    suspend fun getBudgets(): List<Budget>
}

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: Goal)

    @Query("UPDATE goals SET saved = saved + :amount WHERE id = :goalId")
    suspend fun updateGoalProgress(goalId: Int, amount: Double)

    @Query("SELECT * FROM goals")
    suspend fun getGoals(): List<Goal>
}
