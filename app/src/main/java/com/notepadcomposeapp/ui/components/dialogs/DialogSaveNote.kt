package com.notepadcomposeapp.ui.components.dialogs

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.notepadcomposeapp.R
import com.notepadcomposeapp.ui.components.screens.Screen

@Composable
fun DialogSaveNote(dialogState: MutableState<Boolean>, navHostController: NavHostController) {
    if (dialogState.value) {
        Dialog(
            onDismissRequest = {
                dialogState.value = false
            },
            content = {
                DialogContent(navHostController, dialogState)
            }
        )
    }
}

@Composable
private fun DialogContent(
    navHostController: NavHostController,
    dialogState: MutableState<Boolean>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .heightIn(max = 150.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Do you want to save this note ?",
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
            BottomButtons(navHostController, dialogState)
        }
    }
}

@Composable
private fun BottomButtons(
    navHostController: NavHostController,
    dialogState: MutableState<Boolean>
) {
    val context: Context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.padding(end = 10.dp),
            onClick = {
                dialogState.value = false
            }
        ) {
            Text(stringResource(id = R.string.dialog_save_note_action_cancel))
        }
        Button(
            modifier = Modifier.padding(start = 10.dp),
            onClick = {
                dialogState.value = false
                Toast.makeText(context, context.getString(R.string.toast_note_saved), Toast.LENGTH_SHORT).show()
                navHostController.navigate(Screen.ScreenListNotes.route)
            }
        ) {
            Text(stringResource(id = R.string.dialog_save_note_action_confirm))
        }
    }
}