package com.example.unscramble

import android.app.Application
import com.example.unscramble.data.AppDatabase
import com.example.unscramble.data.WordRepository

class UnscrambleApplication : Application() {
    /**
     * AppContainer instance used by the rest of the classes to obtain dependencies
     */
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
    val repository: WordRepository by lazy { WordRepository(database.wordDao()) }
}
