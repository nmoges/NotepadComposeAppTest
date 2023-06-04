package com.notecomposeapp.data.modules

import android.content.Context
import com.notecomposeapp.data.dao.NoteDao
import com.notecomposeapp.data.repositories.NotesRepository
import com.notecomposeapp.data.repositories.NotesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotesRepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        noteDao: NoteDao,
        @ApplicationContext context: Context
    ) : NotesRepository {
        return NotesRepositoryImpl(noteDao)
    }
}