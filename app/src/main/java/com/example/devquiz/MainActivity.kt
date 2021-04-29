package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    private val borderButtonStart by lazy { findViewById<ImageView>(R.id.borderButtonStart) }
    private val buttonStart by lazy { findViewById<Button>(R.id.buttonStart) }
    private val buttonFAB by lazy { findViewById<FloatingActionButton>(R.id.buttonFAB) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        buttonStart.setOnClickListener {
            spinAnimation()
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity<QuizActivity>()
                finish()
            }, 1000)
        }

        buttonFAB.setOnClickListener {
            auth?.signOut()
            startActivity<SignInActivity>()
            finish()
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