package com.julietgisemba.fintrack.data.repository

import com.julietgisemba.fintrack.data.dao.BudgetDao
import com.julietgisemba.fintrack.data.dao.GoalDao
import com.julietgisemba.fintrack.data.dao.TransactionDao
import com.julietgisemba.fintrack.model.Budget
import com.julietgisemba.fintrack.model.Goal
import com.julietgisemba.fintrack.model.TransactionEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FinanceRepository @Inject constructor(private val transactionDao: TransactionDao, private val budgetDao: BudgetDao, private val goalDao: GoalDao) {
    suspend fun addTransaction(transactionEntity: TransactionEntity) = transactionDao.insertTransaction(transactionEntity)
    suspend fun addBudget(budget: Budget) = budgetDao.insertBudget(budget)
    suspend fun addGoal(goal: Goal) = goalDao.insertGoal(goal)

    suspend fun updateBudget(category: String, amount: Double) = budgetDao.updateBudgetSpent(category, amount)
    suspend fun updateGoal(goalId: Int, amount: Double) = goalDao.updateGoalProgress(goalId, amount)

    suspend fun getTransactions() = transactionDao.getAllTransactions()
    suspend fun getBudgets() = budgetDao.getBudgets()
    suspend fun getGoals() = goalDao.getGoals()

}