package com.example.lifruk.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Picture")
data class Picture(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "link_pic")
    var link_pic: String
)