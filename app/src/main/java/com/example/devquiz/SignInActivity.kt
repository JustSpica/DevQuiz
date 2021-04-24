package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

    //Referenciação dos elementos da tela
    private val buttonSignUp by lazy { findViewById<Button>(R.id.buttonSignUp) }
    private val buttonLogIn by lazy { findViewById<Button>(R.id.buttonActivitySignInScreen) }
    private val email by lazy { findViewById<EditText>(R.id.emailInputSignIn) }
    private val password by lazy { findViewById<EditText>(R.id.passwordInputSignIn) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //faz o botao "entrar" logar o usuario e ir para o quiz
        buttonLogIn.setOnClickListener {
            loginUser()
        }
        //faz o botao "cadastre-se" ir parea a tela de cadsastro
        buttonSignUp.setOnClickListener {
            startActivity<SignUpActivity>()
        }
    }

    //método para fazer o login do usuário e verificar se os campos estão preenchidos
    private fun loginUser() {
        val email: String = email.text.toString()
        val password: String = password.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            toast("Preencha todos os campos!!!")
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener  /*caso dê certo, ele manda a toast e vai pra tela de start*/{
                    if (it.isSuccessful) {
                        toast("Cadastro realizado com SUCESSO!!!")
                        buttonSignUp.setOnClickListener {
                            startActivity<MainActivity>()
                        }
                    }
                }.addOnFailureListener /*caso n logue o usuário, gera uma toast de erro*/{
                        toast("Erro ao tentar logar o usuário x(")
                }
        }
    }
}