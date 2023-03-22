package com.example.lifruk.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifruk.R

class QuizGuessPictureActivity : AppCompatActivity() {

    private lateinit var selected_type: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_q_guess_picture)

        getIntentExtra()
    }

    private fun getIntentExtra() {
        selected_type = intent.getStringExtra("selected_type")!!
    }
}