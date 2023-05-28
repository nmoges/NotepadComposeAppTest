package com.notepadcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.notepadcomposeapp.ui.components.ExFloatingActionButtonAddNote
import com.notepadcomposeapp.ui.components.screens.ScreenListNotes
import com.notepadcomposeapp.ui.theme.NotepadComposeAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotepadComposeAppTheme {
                val listState = rememberLazyListState()
                val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    content = { paddingValues ->
                        ScreenListNotes(
                            paddingValues = paddingValues,
                            searchQuery = searchQuery,
                            listState = listState
                        )
                    },
                    floatingActionButton = {
                        ExFloatingActionButtonAddNote(listState)
                    }
                )
            }
        }
    }
}