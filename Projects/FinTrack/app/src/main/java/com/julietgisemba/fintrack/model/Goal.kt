package com.julietgisemba.fintrack.model

data class Goal(
    val title: String,
    val saved: Double,
    val target: Double,
    val monthsLeft: Int = 0

)