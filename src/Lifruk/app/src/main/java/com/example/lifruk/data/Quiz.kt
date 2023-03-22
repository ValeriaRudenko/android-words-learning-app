package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Quiz")
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "dlevel")
    var dlevel: Difficulty,

    @ColumnInfo(name = "type")
    var type: Type
)