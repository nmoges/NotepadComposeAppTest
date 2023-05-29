package com.notepadcomposeapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.notepadcomposeapp.R
import com.notepadcomposeapp.extensions.isScrollingUp
import com.notepadcomposeapp.ui.NoteViewModel
import com.notepadcomposeapp.ui.components.screens.Screen

@Composable
fun ExFloatingActionButtonAddNote(
    navHostController: NavHostController,
    noteViewModel: NoteViewModel
) {
    val listState = noteViewModel.listStateFlow.collectAsState()
    val isVisible = noteViewModel.isFloatingActionButtonVisible.collectAsState()
    if (isVisible.value) {
        ExtendedFloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondary,
            text = {
                Text(
                    text = stringResource(id = R.string.fab_button_label_new_note),
                    color = Color.White
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Edit,
                    contentDescription = stringResource(id = R.string.fab_button_label_new_note),
                    tint = Color.White
                )
            },
            onClick = {
                navHostController.navigate(Screen.EditNoteScreen.route)
            },
            expanded = listState.value.isScrollingUp()
        )
    }
}


