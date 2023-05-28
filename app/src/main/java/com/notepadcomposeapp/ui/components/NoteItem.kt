package com.notepadcomposeapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notepadcomposeapp.model.Note
import com.notepadcomposeapp.ui.theme.Blue80

@Composable
fun NoteItem(note: Note) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Blue80)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = note.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = note.text,
                        modifier = Modifier.padding(top = 10.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.outline,
                        fontSize = 16.sp
                    )
                    Text(
                        text = note.creationDate,
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestNote() {
    val note = Note(
        title = "Note 10",
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id ornare ligula, in feugiat nunc. Mauris non est enim."
    )
    NoteItem(note = note)
}