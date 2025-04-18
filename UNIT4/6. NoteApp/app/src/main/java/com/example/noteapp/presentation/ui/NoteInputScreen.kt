package com.example.noteapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteInputScreen(
    title: String = "Title",
    text: String = "Text",
    onTitleChange: (String) -> Unit = {},
    onTextChange: (String) -> Unit = {},
    onDoneButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Title", color = Color.Red) },
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                // textColor = Color.White,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.DarkGray,
                //backgroundColor = Color(0xFF2C2C2C),
                cursorColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            label = { Text("Text", color = Color.Red) },
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                // textColor = Color.White,
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.DarkGray,
                //backgroundColor = Color(0xFF2C2C2C),
                cursorColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )

        Row {
            Button(
                onClick = onDoneButtonClicked
            ) {
                Text(text = "Done")
            }
        }
    }
}