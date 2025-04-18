package com.example

import android.app.Application
import android.content.Context

class NoteApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        lateinit var context: Context
    }

}