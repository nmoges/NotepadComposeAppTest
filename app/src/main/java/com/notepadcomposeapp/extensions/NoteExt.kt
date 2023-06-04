package com.notepadcomposeapp.extensions

import com.notecomposeapp.data.entities.NoteEntity
import com.notepadcomposeapp.model.Note


fun Note.toNoteEntity() = NoteEntity(
    title = this.title,
    text = this.text,
    creationData = this.creationDate,
    lastUpdateDate = this.lastUpdateData
)