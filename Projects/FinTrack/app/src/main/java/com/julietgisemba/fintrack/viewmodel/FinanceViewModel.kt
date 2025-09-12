package com.julietgisemba.fintrack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julietgisemba.fintrack.data.repository.FinanceRepository
import com.julietgisemba.fintrack.model.Budget
import com.julietgisemba.fintrack.model.BudgetType
import com.julietgisemba.fintrack.model.Goal
import com.julietgisemba.fintrack.model.TransactionEntity
import com.julietgisemba.fintrack.model.TransactionType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class FinanceViewModel @Inject constructor(
    private val repository: FinanceRepository
) : ViewModel() {

    fun addIncome(
        amount: Double,
        title: String = "Income",
        category: String = "General",
        note: String? = null
    ) {
        viewModelScope.launch {
            repository.addTransaction(
                TransactionEntity(
                    title = title,
                    date = Date(),
                    category = category,
                    amount = amount,
                    isIncome = true,
                    note = note,
                    type = TransactionType.INCOME
                )
            )
        }
    }

    fun addExpense(
        amount: Double,
        title: String,
        category: String,
        note: String? = null
    ) {
        viewModelScope.launch {
            repository.addTransaction(
                TransactionEntity(
                    title = title,
                    date = Date(),
                    category = category,
                    amount = amount,
                    isIncome = false,
                    note = note,
                    type = TransactionType.EXPENSE
                )
            )
            repository.updateBudget(category, amount)
        }
    }

    fun addGoal(
        title: String,
        target: Double,
        deadline: Date? = null
    ) {
        viewModelScope.launch {
            repository.addGoal(
                Goal(
                    title = title,
                    target = target,
                    saved = 0.0,
                    deadline = deadline,
                    isActive = true
                )
            )
        }
    }

    fun addBudget(
        categoryName: String,
        limit: Double,
        type: BudgetType,
        isRecurring: Boolean = false,
        startDate: Date? = null,
        endDate: Date? = null
    ) {
        viewModelScope.launch {
            repository.addBudget(
                Budget(
                    categoryName = categoryName,
                    limit = limit,
                    spent = 0.0,
                    type = type,
                    isRecurring = isRecurring,
                    startDate = startDate,
                    endDate = endDate
                )
            )
        }
    }
}
