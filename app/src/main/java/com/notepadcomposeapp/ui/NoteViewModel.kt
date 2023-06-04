package com.notepadcomposeapp.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notecomposeapp.data.repositories.NotesRepository
import com.notepadcomposeapp.extensions.toNote
import com.notepadcomposeapp.extensions.toNoteEntity
import com.notepadcomposeapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val notesRepository: NotesRepository
) : ViewModel() {

    var selectedNote: Note? = null

    private val _listStateFlow = MutableStateFlow(LazyListState())
    val listStateFlow: StateFlow<LazyListState>
        get() = _listStateFlow

    private val _isFloatingActionButtonVisible = MutableStateFlow(true)
    val isFloatingActionButtonVisible: StateFlow<Boolean>
        get() = _isFloatingActionButtonVisible

    private val _listNotes = MutableStateFlow<List<Note>>(mutableListOf())
    val listNotes: StateFlow<List<Note>>
        get() = _listNotes

    // region List notes state
    fun setListState(listState: LazyListState) {
        _listStateFlow.value = listState
    }
    // endregion

    // region Floating action button
    fun setFloatingActionButtonVisibility(isVisible: Boolean) {
        _isFloatingActionButtonVisible.value = isVisible
    }
    // endregion

    // region Database access
    fun insertNote(note: Note) {
        viewModelScope.launch {
            notesRepository.insertNote(note.toNoteEntity())
        }
    }

    fun getListNotes() {
        viewModelScope.launch {
            val notes = mutableListOf<Note>().apply {
                notesRepository.getNotes().forEach {
                    this.add(it.toNote())
                }
            }
            _listNotes.value = notes
        }
    }
    // endregion
}