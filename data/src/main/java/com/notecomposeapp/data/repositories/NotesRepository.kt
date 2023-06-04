package com.notecomposeapp.data.repositories

import com.notecomposeapp.data.entities.NoteEntity

interface NotesRepository {

    suspend fun insertNote(noteEntity: NoteEntity): Long

    suspend fun getNotes(): List<NoteEntity>
}