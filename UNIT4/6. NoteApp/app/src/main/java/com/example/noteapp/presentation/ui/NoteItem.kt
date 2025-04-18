package com.example.noteapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    title: String = "Title",
    text: String = "Text",
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    ) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Cyan),
        modifier = modifier
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = modifier
                    .padding(12.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = title,
                    fontSize = 24.sp,
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Column {

                IconButton(
                    onClick = onDeleteClick,
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                    )
                }


                IconButton(
                    onClick = onEditClick,
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                    )
                }

            }

        }
    }
}


@Composable
@Preview(showBackground = true)
fun NoteItemPreview() {
    Surface {
        NoteItem(
            onDeleteClick = {},
            onEditClick = {}
        )
    }
}
