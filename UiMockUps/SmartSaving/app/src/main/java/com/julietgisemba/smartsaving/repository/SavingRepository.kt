package com.julietgisemba.smartsaving.repository

import com.julietgisemba.smartsaving.data.SavingTransactionDao
import com.julietgisemba.smartsaving.model.SavingTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SavingRepository @Inject constructor(private var savingsDao: SavingTransactionDao) {
    suspend fun getAllTransactions(): Flow<List<SavingTransaction>> =
        savingsDao.getAllTransactions()
            .flowOn(Dispatchers.IO)

    suspend fun addSavings(transaction: SavingTransaction){
        withContext(Dispatchers.IO){
            savingsDao.addSavings(transaction)
        }
    }
}