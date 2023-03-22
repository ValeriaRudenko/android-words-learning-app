package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Flashcard")
data class Flashcard(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "to_guess")
    var to_guess: Word,

    @ColumnInfo(name = "dlevel")
    var dlevel: Difficulty,

    @ColumnInfo(name = "type")
    var type: Type
)
