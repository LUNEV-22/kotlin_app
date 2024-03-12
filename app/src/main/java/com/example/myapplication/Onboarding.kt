package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class Onboarding : AppCompatActivity() {

    private val onboardingContent: List<Map<String, Any>> = listOf(
        mapOf(
            "title" to "Добро пожаловать\n в Клуб Синема!",
            "description" to "",
            "image" to R.drawable.onboarding_img_1
        ),
        mapOf(
            "title" to "Смотри премьеры\nи классику в кино",
            "description" to "Узнавай первый о премьерах новых фильмах и пересматривай любимые фильмы в кинозале",
            "image" to R.drawable.onboarding_img_2
        ),
        mapOf(
            "title" to "Все билеты\nв одном месте",
            "description" to "Покупай и используй билеты в любимых кинотеатрах в одном приложении",
            "image" to R.drawable.onboarding_img_3
        )
    )
    private var step = 0
    // Object
    private lateinit var onboardingImg: ImageView
    private lateinit var onboardingTitle: TextView
    private lateinit var onboardingDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding)

        onboardingImg = findViewById(R.id.onboarding_img)
        onboardingTitle = findViewById(R.id.onboarding_title)
        onboardingDescription = findViewById(R.id.onboarding_description)

        updateScreen()

        // Действия
        findViewById<LinearLayout>(R.id.next_btn).setOnClickListener {
            step++
            updateScreen()
        }

        findViewById<LinearLayout>(R.id.skip_btn).setOnClickListener {
            step = 2
            updateScreen()
        }
    }

    private fun updateScreen(){
        if (step < 3) {
            onboardingImg.setImageResource(onboardingContent[step]["image"] as Int)
            onboardingTitle.text = onboardingContent[step]["title"] as String
            onboardingDescription.text = onboardingContent[step]["description"] as String
            if (step == 2) {
                findViewById<TextView>(R.id.next_btn_text).text = "Начать"
            }
        }
    }

}