package com.example.noteapp.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.repository.NoteRepository
import com.example.noteapp.model.Note
import com.example.noteapp.model.NoteUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class NoteViewModel : ViewModel() {

    private val noteRepository = NoteRepository()

    private val _uiState = MutableStateFlow(NoteUiState())
    val uiState = _uiState.asStateFlow()

    private val _notesListFlow = MutableStateFlow<List<Note>>(emptyList())
    val notesListFlow = _notesListFlow.asStateFlow()

    init {
        getAllNote()
    }

    fun saveNote(id: Int, title: String, text: String) = viewModelScope.launch {
        noteRepository.saveNote(
            Note(
                id = id,
                title = title,
                text = text
            )
        )

        getAllNote()
    }

    private fun getAllNote() = viewModelScope.launch {
        val notes = noteRepository.getAllNote()
        _notesListFlow.emit(notes)
    }

    fun setTitle(title: String) {
        _uiState.update { currentState ->
            currentState.copy(
                title = title
            )
        }
    }

    fun setText(text: String) {
        _uiState.update { currentState ->
            currentState.copy(
                text = text
            )
        }
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
        getAllNote()
    }
}
