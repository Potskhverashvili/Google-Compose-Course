package com.example.noteapp.data.mapper

import com.example.noteapp.data.local.entity.NoteDbo
import com.example.noteapp.model.Note

fun Note.toNoteDbo(): NoteDbo {
    return NoteDbo(
        id = this.id,
        title = this.title,
        text = this.text,
    )
}


fun NoteDbo.toNote(): Note {
    return Note(
        id = this.id,
        title = this.title,
        text = this.text
    )
}