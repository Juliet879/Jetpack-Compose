package com.julietgisemba.quicknotes.data

import com.julietgisemba.quicknotes.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Meeting Notes",
                description = "Discuss the project timeline and deliverables."
            ),
            Note(
                title = "Shopping List",
                description = "Buy milk, eggs, bread, and vegetables."
            ),
            Note(
                title = "Workout Plan",
                description = "Plan the workout routine for the week."
            ),
            Note(
                title = "Book Summary",
                description = "Write a summary of the book 'Atomic Habits'."
            ),
            Note(
                title = "Travel Itinerary",
                description = "Plan the trip to Paris with key destinations and activities."
            )
        )
    }
}