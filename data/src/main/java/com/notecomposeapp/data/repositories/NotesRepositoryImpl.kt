package com.notecomposeapp.data.repositories

import com.notecomposeapp.data.dao.NoteDao
import com.notecomposeapp.data.entities.NoteEntity

class NotesRepositoryImpl(
    private val notesDao: NoteDao
): NotesRepository {
    override suspend fun insertNote(noteEntity: NoteEntity): Long {
        return notesDao.insertNote(noteEntity)
    }

    override suspend fun getNotes(): List<NoteEntity> {
        return notesDao.getAllNotes()
    }
}