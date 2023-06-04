package com.notepadcomposeapp.model

import com.notepadcomposeapp.extensions.getFormattedDate
import java.util.Calendar

data class Note(
    var title: String,
    var text: String,
    var creationDate: String = Calendar.getInstance().getFormattedDate(),
    var lastUpdateDate: String? = null
)