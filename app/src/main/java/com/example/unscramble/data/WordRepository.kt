package com.example.unscramble.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository untuk mengelola akses data kata.
 * Berperan sebagai perantara antara ViewModel dan Database (DAO).
 */
class WordRepository(private val wordDao: WordDao) {
    
    /**
     * Aliran data semua kata dari database.
     */
    val allWords: Flow<List<CorrectWord>> = wordDao.getAllWords()

    /**
     * Fungsi untuk menyimpan kata baru.
     */
    suspend fun insert(word: CorrectWord) {
        wordDao.insert(word)
    }
}
