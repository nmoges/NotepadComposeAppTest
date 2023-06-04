package com.notepadcomposeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.notepadcomposeapp.navigation.Navigation
import com.notepadcomposeapp.ui.components.ExFloatingActionButtonAddNote
import com.notepadcomposeapp.ui.theme.NotepadComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotepadComposeAppTheme {
                navHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    content = {
                        Navigation(
                            navHostController = navHostController,
                            noteViewModel = hiltViewModel()
                        )
                    },
                    floatingActionButton = {
                        ExFloatingActionButtonAddNote(
                            navHostController = navHostController,
                            noteViewModel = hiltViewModel()
                        )
                    }
                )
            }
        }
    }
}