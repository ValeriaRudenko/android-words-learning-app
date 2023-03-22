package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Game")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "player")
    var player: Player,

    @ColumnInfo(name = "score")
    var score: Int

    /*@ColumnInfo(name = "q1")
    var q1: Question,

    @ColumnInfo(name = "q2")
    var q2: Question,

    @ColumnInfo(name = "q3")
    var q3: Question,

    @ColumnInfo(name = "q4")
    var q4: Question,

    @ColumnInfo(name = "q5")
    var q5: Question,

    @ColumnInfo(name = "q6")
    var q6: Question,

    @ColumnInfo(name = "q7")
    var q7: Question,

    @ColumnInfo(name = "q8")
    var q8: Question,

    @ColumnInfo(name = "q9")
    var q9: Question,

    @ColumnInfo(name = "q10")
    var q10: Question*/
)