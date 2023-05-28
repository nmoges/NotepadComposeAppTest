package com.notepadcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.notepadcomposeapp.ui.components.ExFloatingActionButtonAddNote
import com.notepadcomposeapp.ui.components.FloatingActionButtonAddNote
import com.notepadcomposeapp.ui.components.ListNotes
import com.notepadcomposeapp.ui.components.notes
import com.notepadcomposeapp.ui.theme.NotepadComposeAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotepadComposeAppTheme {
                val listState = rememberLazyListState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    content = { paddingValues ->
                        Column(modifier = Modifier.padding(paddingValues)) {
                            ListNotes(notes = notes, listState = listState)
                        }
                    },
                    floatingActionButton = {
                        ExFloatingActionButtonAddNote(listState)
                    }
                )
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ListNotes(notes = notes)
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotepadComposeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
//                ListNotes(notes = notes, listState = listState)
            }
        }
    }
}