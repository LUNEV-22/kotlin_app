package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Onboarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        findViewById<Button>(R.id.Button_1).setOnClickListener {
            val secondView = Intent(this@Onboarding, LoadScreen::class.java)
            startActivity(secondView)
        }
    }
}