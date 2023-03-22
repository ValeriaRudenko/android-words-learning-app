package com.example.lifruk.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface WordDao {

    @Query("SELECT * FROM Word")
    fun getAllWords() : LiveData<List<Word>>

    @Query("SELECT * FROM Word WHERE id = :id")
    fun getWordById(id: Int) : LiveData<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word)

    @Delete
    fun deleteWord(word: Word)

    @Query("DELETE FROM Word")
    suspend fun deleteAllWord()

    @Query("DELETE FROM Word WHERE id = :id")
    fun deleteWordById(id: Int)
}