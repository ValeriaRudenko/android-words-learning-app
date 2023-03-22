package com.example.lifruk.data

enum class Difficulty(val value: Int){
    EASY(0),
    MEDIUM(1),
    HARD(2)
}

enum class Type(val value: Int){
    WORD(0),
    PICTURE(1),
    AUDIO(2)
}

enum class Language(val value: Int){
    ENGLISH(0),
    LITHUANIAN(1),
    UKRAINIAN(2),
    FRENCH(3)
}