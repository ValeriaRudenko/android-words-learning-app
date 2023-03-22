package com.example.lifruk.flashcard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.lifruk.R
import com.example.lifruk.game_menu.GameMenuActivity

class FlashcardActivity : AppCompatActivity() {

    lateinit var flipIn: AnimatorSet
    lateinit var flipOut: AnimatorSet
    var isFront = true

    private lateinit var selected_type: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_flashcard)

        getIntentExtra()
        flip()
    }

    private fun flip() {
        flipIn =
            AnimatorInflater.loadAnimator(applicationContext, R.animator.flip_in) as AnimatorSet
        flipOut =
            AnimatorInflater.loadAnimator(applicationContext, R.animator.flip_out) as AnimatorSet

        val flipButton: Button = findViewById(R.id.flip_button)

        val flashcardFront: ImageView? = findViewById((R.id.flashcard_front))
        val flashcardBack: ImageView? = findViewById((R.id.flashcard_back))

        val scale: Float = applicationContext.resources.displayMetrics.density
        if (flashcardFront != null) flashcardFront.cameraDistance = 6000 * scale
        if (flashcardBack != null) flashcardBack.cameraDistance = 6000 * scale

        flipButton.setOnClickListener {
            if(isFront){
                flipIn.setTarget(flashcardFront)
                flipOut.setTarget(flashcardBack)
                flipIn.start()
                flipOut.start()
                isFront = false
            } else {
                flipIn.setTarget(flashcardBack)
                flipOut.setTarget(flashcardFront)
                flipOut.start()
                flipIn.start()
                isFront = true
            }
        }
    }

    private fun getIntentExtra() {
        selected_type = intent.getStringExtra("selected_type")!!
    }
}
