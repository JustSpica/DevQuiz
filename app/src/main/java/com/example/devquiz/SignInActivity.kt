package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.jetbrains.anko.startActivity

class SignInActivity : AppCompatActivity() {

    private val buttonSignUp by lazy { findViewById<Button>(R.id.buttonSignUp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        buttonSignUp.setOnClickListener {
            startActivity<SignUpActivity>()
            finish()
        }
    }
}