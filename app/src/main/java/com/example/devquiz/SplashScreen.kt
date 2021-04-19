package com.example.devquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    private var delayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 5000

    internal val runnable =  Runnable {
        if(!isFinishing) {
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        delayHandler = Handler(Looper.getMainLooper())
        delayHandler!!.postDelayed(runnable, SPLASH_DELAY)

    }

    override fun onDestroy() {
        super.onDestroy()
        delayHandler?.let {
            it.removeCallbacks(runnable)
        }
    }


}