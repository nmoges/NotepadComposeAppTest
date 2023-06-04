package com.notecomposeapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val text: String,
    @ColumnInfo(name = "creation_date") val creationData: String,
    @ColumnInfo(name = "last_update_date") val lastUpdateDate: String?
)