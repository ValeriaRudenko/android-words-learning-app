package com.example.lifruk.data

import com.example.lifruk.R

class Generator {
    suspend fun generateTopics(topicDao: TopicDao) {
        // Delete all content here.
        topicDao.deleteAllTopic()

        // Add topics
        topicDao.insertTopic(Topic(0, "color"))
        topicDao.insertTopic(Topic(1, "number"))

    }

    suspend fun generateWord(wordDao: WordDao) {
        // Add flashcardDao
        wordDao.insertWord(Word(0, "red", null, "raudona", null, "червоний", null, "rouge", null, R.drawable.red))
        wordDao.insertWord(Word(0, "blue", null, "mėlyna", null, "блакитний", null, "bleu", null, R.drawable.blue))
        wordDao.insertWord(Word(0, "green", null, "žalias", null, "зелений", null, "vert", null, R.drawable.green))
        wordDao.insertWord(Word(0, "yellow", null, "geltona", null, "жовтий", null, "jaune", null, R.drawable.yellow))
        wordDao.insertWord(Word(0, "white", null, "baltas", null, "білий", null, "blanc", null, R.drawable.white))
        wordDao.insertWord(Word(0, "black", null, "juodas", null, "чорний", null, "noir", null, R.drawable.black))
        wordDao.insertWord(Word(0, "pink", null, "rožinis", null, "рожевий", null, "rose", null, R.drawable.pink))
        wordDao.insertWord(Word(0, "orange", null, "oranžinė", null, "помаранчевий", null, "orange", null, R.drawable.orange))
        wordDao.insertWord(Word(0, "violet", null, "violetas", null, "фіолетовий", null, "violet", null, R.drawable.violet))

        wordDao.insertWord(Word(1, "one", null, "vienas", null, "один", null, "un", null, R.drawable.one))
        wordDao.insertWord(Word(1, "zero", null, "nulis", null, "нуль", null, "zéro", null, R.drawable.zero))
        wordDao.insertWord(Word(1, "two", null, "du", null, "два", null, "deux", null, R.drawable.two))
        wordDao.insertWord(Word(1, "three", null, "trys", null, "три", null, "trois", null, R.drawable.three))
        wordDao.insertWord(Word(1, "four", null, "keturi", null, "чотири", null, "quatre", null, R.drawable.four))
        wordDao.insertWord(Word(1, "five", null, "penkios", null, "п'ять", null, "cinq", null, R.drawable.five))
        wordDao.insertWord(Word(1, "six", null, "šeši", null, "шість", null, "six", null, R.drawable.six))
        wordDao.insertWord(Word(1, "seven", null, "septyni", null, "сім", null, "sept", null, R.drawable.seven))
        wordDao.insertWord(Word(1, "eight", null, "aštuoni", null, "вісім", null, "huit", null, R.drawable.eight))
        wordDao.insertWord(Word(1, "nine", null, "devynios", null, "дев'ять", null, "neuf", null, R.drawable.nine))

    }

    suspend fun generateFlashcard(flashcardDao: FlashcardDao) {
        // Add flashcardDao
        //flashcardDao.insertFlashcard(Flashcard(0, ))
    }
    suspend fun generateQuestion(questionDao: QuestionDao) {
        //Add quizQuestions
        //QuestionDao.insertQuestion(Question(0,"W", null, "raudona", null, "червоний", null, "rouge", null, R.drawable.red))
    }
}