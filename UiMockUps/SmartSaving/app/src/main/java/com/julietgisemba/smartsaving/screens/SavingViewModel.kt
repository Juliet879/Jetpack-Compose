package com.julietgisemba.smartsaving.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julietgisemba.smartsaving.model.SavingTransaction
import com.julietgisemba.smartsaving.repository.SavingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
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
        calculateSavings()
    }

    fun calculateSavings(){
        val savingsList = mutableListOf<SavingTransaction>()
        for (week in 1..52){
            val weeklyAmount = week * startAmount
            savingsList.add(SavingTransaction(week = week, amount = weeklyAmount))
        }
        _totalSavings.value = savingsList
    }

    fun addSavings(transaction: SavingTransaction) = viewModelScope.launch {
        repository.addSavings(transaction)
    }
}