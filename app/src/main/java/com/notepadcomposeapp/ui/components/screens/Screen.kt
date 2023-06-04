package com.notepadcomposeapp.ui.components.screens

sealed class Screen(val route: String) {

    object ScreenListNotes : Screen("screen_list_notes")
    object ScreenEditNote : Screen("screen_edit_note")
}