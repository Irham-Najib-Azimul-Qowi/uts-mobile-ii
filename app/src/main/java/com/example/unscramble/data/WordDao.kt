package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object untuk tabel correct_words.
 * Menyediakan metode untuk memasukkan data dan mengambil semua data secara reaktif menggunakan Flow.
 */
@Dao
interface WordDao {
    /**
     * Menyimpan kata baru ke database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: CorrectWord)

    /**
     * Mengambil semua kata yang tersimpan, diurutkan dari yang terbaru (ID tertinggi).
     * Menggunakan Flow agar UI dapat diperbarui secara otomatis ketika ada perubahan data.
     */
    @Query("SELECT * FROM correct_words ORDER BY id DESC")
    fun getAllWords(): Flow<List<CorrectWord>>
}
