package com.notepadcomposeapp.ui.components.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.notepadcomposeapp.ui.NoteViewModel
import com.notepadcomposeapp.ui.components.ListNotes
import com.notepadcomposeapp.ui.components.SearchTextField
import com.notepadcomposeapp.ui.components.notes

@Composable
fun ScreenListNotes(noteViewModel: NoteViewModel, navHostController: NavHostController) {
    Column {
        Spacer(modifier = Modifier.height(15.dp))
        SearchTextField()
        Spacer(modifier = Modifier.height(5.dp))
        ListNotes(
            navHostController = navHostController,
            notes = notes,
            noteViewModel = noteViewModel
        )
    }
}