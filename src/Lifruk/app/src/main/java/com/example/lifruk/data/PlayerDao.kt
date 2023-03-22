package com.example.lifruk.data

import androidx.lifecycle.LiveData
import androidx.room.*

interface PlayerDao {
    @Query("SELECT * FROM Player")
    fun getAllPlayers() : LiveData<List<Player>>

    @Query("SELECT * FROM Player WHERE id = :id")
    fun getPlayerById(id: Int) : LiveData<Player>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)

    @Query("DELETE FROM Player")
    suspend fun deleteAllPlayer()

    @Query("DELETE FROM Player WHERE id = :id")
    fun deletePlayerById(id: Int)
}