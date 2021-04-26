package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.devquiz.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val buttonSingUp by lazy { findViewById<Button>(R.id.buttonActivitySignUpScreen) }
    private val userNameEditText by lazy { findViewById<EditText>(R.id.userNameInputSignUp) }
    private val emailEditText by lazy { findViewById<EditText>(R.id.emailInputSignUp) }
    private val passwordEditText by lazy { findViewById<EditText>(R.id.passwordlInputSignUp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth

        buttonSingUp.setOnClickListener {
            declareData()
        }
    }

    private fun declareData() {
        val user = User()

        user.userName = userNameEditText.text.toString()
        user.email = emailEditText.text.toString()
        user.password = passwordEditText.text.toString()

        if (user.userName.isEmpty() || user.email.isEmpty() || user.password.isEmpty()) {
            toast("Por favor, preencha todos os campos.")
        } else {
            auth.createUserWithEmailAndPassword(
                user.email,
                user.password
            ).addOnCompleteListener {
                if(it.isSuccessful) {
                    toast("foi")
                    startActivity<MainActivity>()
                    finish()
                } else {
                    toast("não foi")
                    Log.w("signInWithEmail:failure", it.exception)
                }
            }
        }
    }
}