package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Response")
data class Response(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "response1")
    var response1: String,

    @ColumnInfo(name = "response2")
    var response2: String?,

    @ColumnInfo(name = "response3")
    var response3: String?,

    @ColumnInfo(name = "response4")
    var response4: String?,

    @ColumnInfo(name = "good_one")
    var good_one: Int
)