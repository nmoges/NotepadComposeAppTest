package com.notepadcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.notepadcomposeapp.ui.components.screens.Screen
import com.notepadcomposeapp.ui.components.screens.ScreenListNotes

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.ScreenListNotes.route) {
        composable(route = Screen.ScreenListNotes.route) {
            it.destination.label = Screen.ScreenListNotes::class.java.simpleName
        }

        composable(route = Screen.EditNoteScreen.route) {
            it.destination.label = Screen.EditNoteScreen::class.java.simpleName
        }
    }
}