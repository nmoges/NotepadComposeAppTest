package com.notepadcomposeapp.ui.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.notepadcomposeapp.ui.components.ListNotes
import com.notepadcomposeapp.ui.components.SearchTextField
import com.notepadcomposeapp.ui.components.notes

@Composable
fun ScreenListNotes(
    paddingValues: PaddingValues,
    searchQuery: MutableState<TextFieldValue>,
    listState: LazyListState
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Spacer(modifier = Modifier.height(15.dp))
        SearchTextField(searchQuery)
        Spacer(modifier = Modifier.height(5.dp))
        ListNotes(notes = notes, listState = listState)
    }
}