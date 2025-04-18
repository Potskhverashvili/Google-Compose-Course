package com.example.noteapp.data.local.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(note: NoteDbo)

    @Update
    suspend fun updateNote(note: NoteDbo)

    @Delete
    suspend fun deleteNote(note: NoteDbo)

    @Query("SELECT * FROM notes_table")
    suspend fun getAllNote(): List<NoteDbo>
}