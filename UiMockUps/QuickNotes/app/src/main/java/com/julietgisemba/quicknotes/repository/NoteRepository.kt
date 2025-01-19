package com.julietgisemba.quicknotes.repository

import com.julietgisemba.quicknotes.data.NoteDao
import com.julietgisemba.quicknotes.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private var noteDao: NoteDao) {
    suspend fun addNote(note: Note) = noteDao.addNote(note)

    suspend fun removeNote(note: Note) = noteDao.deleteNote(note)

    suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    suspend fun deleteAllNotes() = noteDao.deleteAllNotes()

    fun getAllNotes(): Flow<List<Note>> = noteDao.getNotes().flowOn(Dispatchers.IO).conflate()

}