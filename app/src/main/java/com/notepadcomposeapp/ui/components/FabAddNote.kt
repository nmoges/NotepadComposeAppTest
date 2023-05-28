package com.notepadcomposeapp.ui.components

import android.util.Log
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.notepadcomposeapp.R
import com.notepadcomposeapp.extensions.isScrollingUp

@Deprecated("Just for testing")
@Preview
@Composable
fun FloatingActionButtonAddNote() {
    FloatingActionButton(
        onClick = {
            // Handle onClick method
            Log.d("TEST_FAB", "Click detected")
        },
        containerColor = MaterialTheme.colorScheme.secondary,
        shape = RoundedCornerShape(16.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Edit,
            contentDescription = "Add new note",
            tint = Color.White
        )
    }
}

@Composable
fun ExFloatingActionButtonAddNote(listState: LazyListState) {
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
        onClick = { },
        expanded = listState.isScrollingUp(),
    )
}


