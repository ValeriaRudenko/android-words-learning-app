package com.example.lifruk

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.lifruk.data.AppDatabase
import com.example.lifruk.data.DATABASE_NAME
import com.example.lifruk.repository.TopicRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { TopicRepository(database.topicDao()) }
}
