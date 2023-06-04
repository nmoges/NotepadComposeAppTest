package com.notepadcomposeapp.ui.components.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.notepadcomposeapp.R
import com.notepadcomposeapp.ui.NoteViewModel
import com.notepadcomposeapp.ui.components.ListNotes
import com.notepadcomposeapp.ui.components.SearchTextField

@Composable
fun ScreenListNotes(noteViewModel: NoteViewModel, navHostController: NavHostController) {
    val isListNotesEmpty = remember { mutableStateOf(true) }
    val listNotes = noteViewModel.listNotes.collectAsState()
    // Load list of existing notes from database
    noteViewModel.getListNotes()

    Column {
        Spacer(modifier = Modifier.height(15.dp))
        SearchTextField()
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Check if list is empty
            isListNotesEmpty.value = listNotes.value.isEmpty()

            if (isListNotesEmpty.value.not()) {
                ListNotes(
                    navHostController = navHostController,
                    notes = listNotes.value,
                    noteViewModel = noteViewModel
                )
            } else {
                // TODO : fix text not centered
                Text(
                    text = stringResource(id = R.string.text_label_empty),
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
