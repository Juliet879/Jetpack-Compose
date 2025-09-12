package com.julietgisemba.fintrack.data.di

import android.content.Context
import androidx.room.Room
import com.julietgisemba.fintrack.data.database.FinanceDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FinanceDatabase =
        Room.databaseBuilder(context, FinanceDatabase::class.java, "fintrack_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideTransactionDao(db: FinanceDatabase) = db.transactionDao()

    @Provides
    fun provideBudgetDao(db: FinanceDatabase) = db.budgetDao()

    @Provides
    fun provideGoalDao(db: FinanceDatabase) = db.goalDao()
}