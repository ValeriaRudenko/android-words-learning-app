package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "pwd")
    var pwd: String,

    @ColumnInfo(name = "native_l")
    var native_l: String,

    @ColumnInfo(name = "learning_l")
    var learning_l: String
)
