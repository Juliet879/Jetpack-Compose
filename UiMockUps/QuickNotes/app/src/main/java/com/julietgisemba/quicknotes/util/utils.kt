package com.julietgisemba.quicknotes.util

import java.text.SimpleDateFormat
import java.util.Date

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa")
    return format.format(date)
}