package com.example.lifruk.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface QuizDao {
    @Query("SELECT * FROM Quiz")
    fun getAllQuizs() : LiveData<List<Quiz>>

    @Query("SELECT * FROM Quiz WHERE id = :id")
    fun getQuizById(id: Int) : LiveData<Quiz>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuiz(quiz: Quiz)

    @Delete
    fun deleteQuiz(quiz: Quiz)

    @Query("DELETE FROM Quiz")
    suspend fun deleteAllQuiz()

    @Query("DELETE FROM Quiz WHERE id = :id")
    fun deleteQuizById(id: Int)
}