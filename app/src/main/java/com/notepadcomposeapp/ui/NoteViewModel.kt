package com.notepadcomposeapp.ui

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NoteViewModel: ViewModel() {

    // region List notes state
    private val _listStateFlow = MutableStateFlow<LazyListState>(LazyListState())
    val listStateFlow: StateFlow<LazyListState>
        get() = _listStateFlow

    fun setListState(listState: LazyListState) {
        _listStateFlow.value = listState
    }
    // endregion
}