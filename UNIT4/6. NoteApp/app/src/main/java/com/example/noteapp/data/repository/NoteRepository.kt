package com.example.noteapp.data.repository

import android.util.Log.d
import com.example.NoteApplication
import com.example.noteapp.data.local.NotesDataBase
import com.example.noteapp.data.mapper.toNote
import com.example.noteapp.data.mapper.toNoteDbo
import com.example.noteapp.model.Note

class NoteRepository {

    private val noteDao = NotesDataBase.create(NoteApplication.context).noteDao

    suspend fun saveNote(note: Note) {
        noteDao.saveNote(note.toNoteDbo())
    }

    suspend fun getAllNote(): List<Note> {
        return noteDao.getAllNote().map { it.toNote() }
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteDbo())
    }

}