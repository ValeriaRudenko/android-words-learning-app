package com.example.lifruk.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface PictureDao {
    @Query("SELECT * FROM Picture")
    fun getAllPictures() : LiveData<List<Picture>>

    @Query("SELECT * FROM Picture WHERE id = :id")
    fun getPictureById(id: Int) : LiveData<Picture>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPicture(picture: Picture)

    @Delete
    fun deletePicture(picture: Picture)

    @Query("DELETE FROM Picture")
    suspend fun deleteAllPicture()

    @Query("DELETE FROM Picture WHERE id = :id")
    fun deletePictureById(id: Int)
}