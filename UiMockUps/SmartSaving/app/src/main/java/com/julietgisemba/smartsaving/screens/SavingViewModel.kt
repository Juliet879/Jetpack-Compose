package com.julietgisemba.smartsaving.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julietgisemba.smartsaving.model.SavingTransaction
import com.julietgisemba.smartsaving.repository.SavingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class SavingViewModel @Inject constructor(private var repository: SavingRepository): ViewModel() {
    private val _totalSavings = MutableStateFlow<List<SavingTransaction>>(emptyList())
    val totalSavings = _totalSavings

    private var startAmount: Double = 50.0

    init {
        viewModelScope.launch {
            repository.getAllTransactions()
                .collect() {
                    _totalSavings.value = it
                }

        }
    }

    fun updateStartAmount(amount: Double) {
        startAmount = amount
        viewModelScope.launch {
            calculateSavings()
        }
    }

    fun calculateCurrentWeek(startDate: LocalDate): Int {
        val now = LocalDate.now()
        return ChronoUnit.WEEKS.between(startDate, now).toInt() + 1
    }

    private suspend fun calculateSavings(){
        val savingsList = mutableListOf<SavingTransaction>()
        val startDate = repository.getStartDate() ?: return
        val currentWeek = calculateCurrentWeek(startDate)

        var currentAmount = startAmount
        for (week in 1..currentWeek){
            savingsList.add(SavingTransaction(week = week, amount = currentAmount))
            currentAmount += startAmount
        }
        _totalSavings.value = savingsList
    }

    fun addSavings(transaction: SavingTransaction) = viewModelScope.launch {
        repository.addSavings(transaction)
    }
}