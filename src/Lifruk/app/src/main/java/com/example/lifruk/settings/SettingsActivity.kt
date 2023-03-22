package com.example.lifruk.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifruk.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_content, SettingsFragment())
            .commit()
    }
}

