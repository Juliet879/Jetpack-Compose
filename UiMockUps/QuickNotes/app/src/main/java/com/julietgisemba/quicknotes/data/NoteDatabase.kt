package com.julietgisemba.quicknotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.julietgisemba.quicknotes.model.Note
import com.julietgisemba.quicknotes.util.DateConverter
import com.julietgisemba.quicknotes.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}