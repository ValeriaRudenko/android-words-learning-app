package com.example.lifruk.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface QuestionDao {
    @Query("SELECT * FROM Question")
    fun getAllQuestions() : LiveData<List<Question>>

    @Query("SELECT * FROM Question WHERE id = :id")
    fun getQuestionById(id: Int) : LiveData<Question>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestion(question: Question)

    @Delete
    fun deleteQuestion(question: Question)

    @Query("DELETE FROM Question")
    suspend fun deleteAllQuestion()

    @Query("DELETE FROM Question WHERE id = :id")
    fun deleteQuestionById(id: Int)
}