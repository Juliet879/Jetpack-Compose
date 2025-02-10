package com.julietgisemba.smartsaving.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.julietgisemba.smartsaving.model.SavingTransaction
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.util.Date

@Dao
interface SavingTransactionDao {
    @Query("SELECT * FROM saving_transaction")
    fun getAllTransactions(): Flow<List<SavingTransaction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSavings(transaction: SavingTransaction)

    @Query("SELECT * FROM saving_transaction WHERE id= 1 LIMIT 1")
        fun getStartDate(): LocalDate?
}