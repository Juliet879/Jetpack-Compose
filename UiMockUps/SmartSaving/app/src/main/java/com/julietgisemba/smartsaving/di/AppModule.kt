package com.julietgisemba.smartsaving.di

import android.content.Context
import androidx.room.Room
import com.julietgisemba.smartsaving.data.SavingTransactionDao
import com.julietgisemba.smartsaving.data.SavingTransactionDatabase
import com.julietgisemba.smartsaving.model.SavingTransaction
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideDao(database: SavingTransactionDatabase) =
        database.savingTransactionDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            SavingTransactionDatabase::class.java,
            "saving_transaction"
        ).fallbackToDestructiveMigration()
            .build()

}