package com.example.lifruk.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Word")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "english_word")
    var english_word: String?,

    @ColumnInfo(name = "english_pronunciation")
    var english_pronunciation: String?,

    @ColumnInfo(name = "lithuanian_word")
    var lithuanian_word: String?,

    @ColumnInfo(name = "lithuanian_pronunciation")
    var lithuanian_pronunciation: String?,

    @ColumnInfo(name = "ukrainian_word")
    var ukrainian_word: String?,

    @ColumnInfo(name = "ukrainian_pronunciation")
    var ukrainian_pronunciation: String?,

    @ColumnInfo(name = "french_word")
    var french_word: String?,

    @ColumnInfo(name = "french_pronunciation")
    var french_pronunciation: String?,

    @ColumnInfo(name = "picture")
    var picture: Int?,

    //@ColumnInfo(name = "picture_url")
    //val picture_url: Bitmap?
)