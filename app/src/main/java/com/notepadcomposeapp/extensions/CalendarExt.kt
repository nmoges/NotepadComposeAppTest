package com.notepadcomposeapp.extensions

import java.util.*

fun Calendar.getFormattedDate(): String {
    val year = this.get(Calendar.YEAR)
    val month = this.get(Calendar.MONTH) + 1
    val day = this.get(Calendar.DAY_OF_MONTH)
    val hour = this.get(Calendar.HOUR_OF_DAY)
    val minutes = this.get(Calendar.MINUTE)
    return "$day-$month-$year $hour:$minutes"
}