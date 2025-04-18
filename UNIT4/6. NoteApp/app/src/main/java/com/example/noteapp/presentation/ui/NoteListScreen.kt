package com.example.noteapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.model.Note


@Composable
fun NoteListScreen(
    notesList: List<Note>,
    onDeleteClick: (note: Note) -> Unit = {},
    onCreateNoteClicked: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(notesList) { note ->
                NoteItem(
                    title = note.title,
                    text = note.text,
                    onDeleteClick = { onDeleteClick.invoke(note) },
                    onEditClick = {}
                )
            }
        }

        Button(
            onClick = onCreateNoteClicked,
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .padding(12.dp)
                .size(70.dp)
                .align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun NoteListScreenPreview() {
    Surface() {
        NoteListScreen(listOf(Note(1, "title", "Text")))
    }
}