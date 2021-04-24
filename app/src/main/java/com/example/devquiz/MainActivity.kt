package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private val borderButtonStart by lazy { findViewById<ImageView>(R.id.borderButtonStart) }
    private val buttonStart by lazy { findViewById<Button>(R.id.buttonStart) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            spinAnimation()
            Handler(Looper.getMainLooper()).postDelayed({
                callFragmentQuiz(savedInstanceState)
                buttonStart.visibility = View.INVISIBLE
            }, 1000)
        }
    }

    private fun spinAnimation() {
        val spinAnimation: Animation = AnimationUtils.loadAnimation(
            this,
            R.anim.spin_animation_button_start
        )
        borderButtonStart.startAnimation(spinAnimation)
    }

    private fun callFragmentQuiz(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<QuizFragment>(R.id.frame1)
            }
        }
    }
}