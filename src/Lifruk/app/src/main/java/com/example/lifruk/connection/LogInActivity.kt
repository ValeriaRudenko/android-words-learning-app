package com.example.lifruk.connection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.lifruk.R
import com.example.lifruk.game_menu.GameMenuActivity

class LogInActivity : AppCompatActivity() {
    private lateinit var login_go_signin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        login_go_signin = findViewById(R.id.login_go_signin)
        login_go_signin.setOnClickListener { selectSignIn() }
    }

    private fun selectSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}