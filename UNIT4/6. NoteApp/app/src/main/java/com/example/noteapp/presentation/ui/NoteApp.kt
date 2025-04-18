package com.example.noteapp.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class NoteApp() {
    NoteList,
    NoteInput
}

@Composable
fun NoteApp(
    viewModel: NoteViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    val notesLIst by viewModel.notesListFlow.collectAsState()

    val coroutine = rememberCoroutineScope()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = NoteApp.valueOf(
        backStackEntry?.destination?.route ?: NoteApp.NoteList.name
    )

    NavHost(
        navController = navController,
        startDestination = NoteApp.NoteList.name,
    ) {
        composable(route = NoteApp.NoteList.name) {
            NoteListScreen(
                notesList = notesLIst,
                onDeleteClick = { viewModel.deleteNote(it) },
                onCreateNoteClicked = {
                    navController.navigate(NoteApp.NoteInput.name)
                },
            )
        }

        composable(route = NoteApp.NoteInput.name) {
            NoteInputScreen(
                title = uiState.title,
                text = uiState.text,
                onTitleChange = { viewModel.setTitle(it) },
                onTextChange = { viewModel.setText(it) },
                onDoneButtonClicked = {
                    viewModel.saveNote(uiState.id, uiState.title, uiState.text)
                    navController.navigate(NoteApp.NoteList.name)
                }
            )
        }

    }

}


@Composable
@Preview(showBackground = true)
fun NoteAppPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        NoteApp()
    }
}