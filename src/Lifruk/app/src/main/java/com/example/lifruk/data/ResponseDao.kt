package com.example.lifruk.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ResponseDao {
    @Query("SELECT * FROM Response")
    fun getAllResponses() : LiveData<List<Response>>

    @Query("SELECT * FROM Response WHERE id = :id")
    fun getResponseById(id: Int) : LiveData<Response>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertResponse(response: Response)

    @Delete
    fun deleteResponse(response: Response)

    @Query("DELETE FROM Response")
    suspend fun deleteAllResponse()

    @Query("DELETE FROM Response WHERE id = :id")
    fun deleteResponseById(id: Int)
}