package com.julietgisemba.fintrack.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "goals")
data class Goal(
    val title: String,
    val target: Double,
    val saved: Double = 0.0,
    val deadline: Date? = null,
    val isActive: Boolean = true,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    )