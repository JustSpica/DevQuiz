package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val borderButtonStart by lazy { findViewById<ImageView>(R.id.borderButtonStart) }
    private val buttonStart by lazy { findViewById<Button>(R.id.buttonStart) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            spinAnimation()
        }
    }

    private fun spinAnimation() {
        val spinAnimation: Animation = AnimationUtils.loadAnimation(
            this,
            R.anim.spin_animation_button_start
        )

        borderButtonStart.startAnimation(spinAnimation)
    }
}