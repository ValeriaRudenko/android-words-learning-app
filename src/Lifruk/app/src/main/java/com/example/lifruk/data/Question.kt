package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Question")
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "to_guess")
    var to_guess: String,

    @ColumnInfo(name = "response")
    var response: Response,

    @ColumnInfo(name = "dlevel")
    var dlevel: Difficulty,

    @ColumnInfo(name = "type")
    var type: Type
)