package com.julietgisemba.quicknotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @ColumnInfo(name = "creation_time")
    val creationDate: Date = Date.from(Instant.now())
) {
    @Ignore
    constructor() : this(UUID.randomUUID(), "", "", Date.from(Instant.now()))

}

