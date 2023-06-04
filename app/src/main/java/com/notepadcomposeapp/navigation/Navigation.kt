package com.notepadcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.notepadcomposeapp.ui.NoteViewModel
import com.notepadcomposeapp.ui.components.screens.Screen
import com.notepadcomposeapp.ui.components.screens.ScreenEditNote
import com.notepadcomposeapp.ui.components.screens.ScreenListNotes

@Composable
fun Navigation(
    navHostController: NavHostController,
    noteViewModel: NoteViewModel
) {
    NavHost(navController = navHostController, startDestination = Screen.ScreenListNotes.route) {
        composable(route = Screen.ScreenListNotes.route) {
            it.destination.label = Screen.ScreenListNotes::class.java.simpleName
            noteViewModel.setFloatingActionButtonVisibility(true)
            ScreenListNotes(noteViewModel, navHostController)
        }

        composable(route = Screen.ScreenEditNote.route) {
            it.destination.label = Screen.ScreenEditNote::class.java.simpleName
            noteViewModel.setFloatingActionButtonVisibility(false)
            ScreenEditNote(noteViewModel, navHostController)
        }
    }
}