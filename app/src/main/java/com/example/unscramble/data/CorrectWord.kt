package com.example.unscramble.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity yang merepresentasikan kata yang berhasil ditebak dengan benar.
 * Data ini akan disimpan di tabel "correct_words" dalam Room Database.
 */
@Entity(tableName = "correct_words")
data class CorrectWord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    
    @ColumnInfo(name = "word")
    val word: String
)
