package com.notecomposeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.notecomposeapp.data.entities.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(noteEntity: NoteEntity): Long

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteEntity>
}