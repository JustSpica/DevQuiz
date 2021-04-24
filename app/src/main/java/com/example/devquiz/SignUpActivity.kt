package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.startActivity

class SignUpActivity : AppCompatActivity() {

    private val buttonSignUp by lazy { findViewById<Button>(R.id.buttonActivitySignUpScreen) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        buttonSignUp.setOnClickListener {
            startActivity<MainActivity>()
            finish()
        }
    }
}