package com.example.lifruk.connection

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.lifruk.R

class SignInActivity : AppCompatActivity() {
    private lateinit var signin_go_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val categorie = findViewById<View>(R.id.signin_listLanguage) as Spinner
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.listL,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorie.adapter = adapter

        signin_go_login = findViewById(R.id.signin_go_login)
        signin_go_login.setOnClickListener { selectLogIn() }
    }

    private fun selectLogIn() {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }
}