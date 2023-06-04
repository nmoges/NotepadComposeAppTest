package com.notepadcomposeapp.ui.components.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.notepadcomposeapp.R
import com.notepadcomposeapp.ui.NoteViewModel
import com.notepadcomposeapp.ui.components.dialogs.DialogSaveNote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenEditNote(
    noteViewModel: NoteViewModel,
    navHostController: NavHostController
) {
    val inputTitleValue = remember { mutableStateOf(TextFieldValue()) }
    val inputDescriptionValue = remember { mutableStateOf(TextFieldValue()) }
    val dialogState: MutableState<Boolean> = remember { mutableStateOf(false) }

    // Check if need to edit a selected note
    noteViewModel.selectedNote?.let {
        inputTitleValue.value = TextFieldValue(it.title)
        inputDescriptionValue.value = TextFieldValue(it.text)
        // Prevent recomposition with same values
        noteViewModel.selectedNote = null
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            DisplayTopOptions(dialogState, navHostController)
            // Note title
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = inputTitleValue.value,
                onValueChange = { value ->
                    inputTitleValue.value = value
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 22.sp
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.text_field_hint_note_title),
                        fontSize = 22.sp
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            // Note description
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                value = inputDescriptionValue.value,
                onValueChange = {
                    inputDescriptionValue.value = it
                },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.text_field_hint_note_description),
                        fontSize = 18.sp
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }
        // Dialog
        if (dialogState.value) {
            DialogSaveNote(dialogState, navHostController)
        }
    }
}

@Composable
fun DisplayTopOptions(
    dialogState: MutableState<Boolean>,
    navHostController: NavHostController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Action "Back"
        IconButton(
            onClick = {
                navHostController.navigate(Screen.ScreenListNotes.route)
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = Color.Black,
                contentDescription = ""
            )
        }
        Row {
            // Action "Save note"
            IconButton(
                onClick = {
                    dialogState.value = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    tint = Color.Black,
                    contentDescription = ""
                )
            }
            // Action "Share note"
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    tint = Color.Black,
                    contentDescription = ""
                )
            }
        }
    }
}