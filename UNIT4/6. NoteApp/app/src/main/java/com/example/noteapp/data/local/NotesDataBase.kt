package com.example.noteapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.data.local.entity.NoteDao
import com.example.noteapp.data.local.entity.NoteDbo

@Database(entities = [NoteDbo::class], version = 1)
abstract class NotesDataBase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object{
        fun create (context : Context): NotesDataBase{
            return Room.databaseBuilder(
                context = context,
                NotesDataBase::class.java,
                "NotesDataBase"
            ).build()
        }
    }
}
