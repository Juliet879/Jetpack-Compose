package com.julietgisemba.smartsaving.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.julietgisemba.smartsaving.model.SavingTransaction
import kotlinx.coroutines.flow.Flow

@Dao
interface SavingTransactionDao {
    @Query("SELECT * FROM `transaction`")
    fun getAllTransactions(): Flow<List<SavingTransaction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSavings(transaction: SavingTransaction)
}