package com.julietgisemba.triviaapp.repository

import android.util.Log
import com.julietgisemba.triviaapp.data.DataOrException
import com.julietgisemba.triviaapp.model.QuestionItem
import com.julietgisemba.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrQuestion =
        DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrQuestion.loading = true
            dataOrQuestion.data = api.getAllQuestions()
            if (dataOrQuestion.data.toString().isNotEmpty()) dataOrQuestion.loading = false

        } catch (exception: Exception) {
            dataOrQuestion.e = exception
            Log.d("Exc", "getAllQuestions: ${dataOrQuestion.e!!.localizedMessage}")
        }
        return dataOrQuestion
    }
}