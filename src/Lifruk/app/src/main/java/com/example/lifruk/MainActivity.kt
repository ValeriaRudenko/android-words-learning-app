package com.example.lifruk

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.lifruk.connection.LogInActivity
import com.example.lifruk.game_menu.GameMenuActivity
import com.example.lifruk.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button_flashcard: Button
    private lateinit var button_quiz: Button
    private lateinit var button_connection: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        button_flashcard = findViewById(R.id.button_flashcard)
        button_flashcard.setOnClickListener { selectGame("flashcard") }

        button_quiz = findViewById(R.id.button_quiz)
        button_quiz.setOnClickListener { selectGame("quiz") }

        button_connection = findViewById(R.id.button_connection)
        button_connection.setOnClickListener { selectConnection() }
    }

    private fun selectGame(game: String) {
        val intent = Intent(this, GameMenuActivity::class.java)
        intent.putExtra(GameMenuActivity.EXTRA_GAME, game)
        startActivity(intent)
    }

    private fun selectConnection() {
        val intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.settings) {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        return true
    }
}