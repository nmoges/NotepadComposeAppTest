package com.notecomposeapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notecomposeapp.data.dao.NoteDao
import com.notecomposeapp.data.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}