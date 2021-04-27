package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.devquiz.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    private var authStateListener: FirebaseAuth.AuthStateListener? = null
    private var user: FirebaseUser? = null

    private val buttonSignIn by lazy { findViewById<Button>(R.id.buttonActivitySignInScreen) }
    private val buttonForgetPassword by lazy { findViewById<Button>(R.id.buttonForgetPassword) }
    private val emailSignIn by lazy { findViewById<EditText>(R.id.emailInputSignIn) }
    private val passwordSignIn by lazy { findViewById<EditText>(R.id.passwordInputSignIn) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        user = auth?.currentUser


        authStateListener = FirebaseAuth.AuthStateListener {
            authenticateData()
        }

        buttonSignIn.setOnClickListener {
            fetchData()
        }

        buttonForgetPassword.setOnClickListener {
            forgetPassword()
        }
    }

    private fun forgetPassword() {
        if (emailSignIn.text.toString().isEmpty()) {
            toast("Diga seu email no campo acima")
        }
        auth?.sendPasswordResetEmail(emailSignIn.text.toString())?.addOnCompleteListener {
            if (it.isSuccessful) {
                toast("Um email com redefinição de senha foi enviado para sua conta.")
            } else {
                toast("Erro ao tentar redefinir a senha.")
                Log.w("forgetPassword:failure", it.exception)
            }
        }
    }

    private fun authenticateData() {
        if (user != null) {
            startActivity<MainActivity>()
            finish()
        }
    }

    private fun fetchData() {
        if (emailSignIn.text.toString().isEmpty() || passwordSignIn.text.toString().isEmpty()) {
            toast("digite usuario e/ou senha")
        }

        val user = User()
        user.email = emailSignIn.text.toString()
        user.password = passwordSignIn.text.toString()


        auth?.signInWithEmailAndPassword(user.email, user.password)
            ?.addOnCompleteListener {
                if (it.isSuccessful) {
                    toast("logado!!")
                    startActivity<MainActivity>()
                    finish()
                } else {
                    toast("N foi")
                }
            }
    }

    override fun onStart() {
        super.onStart()
        auth?.addAuthStateListener(authStateListener!!)
    }

    override fun onStop() {
        super.onStop()
        if (authStateListener != null) {
            auth?.removeAuthStateListener(authStateListener!!)
        }
    }
}
