package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SignUpActivity : AppCompatActivity() {


    private val buttonSingUp by lazy { findViewById<Button>(R.id.buttonActivitySignUpScreen) }
    private val userNameEditText by lazy { findViewById<EditText>(R.id.userNameInputSignUp) }
    private val emailEditText by lazy { findViewById<EditText>(R.id.emailInputSignUp) }
    private val passwordEditText by lazy { findViewById<EditText>(R.id.passwordlInputSignUp) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //setando o botão cadastrar para executar os métodos de cadastro do bd
        buttonSingUp.setOnClickListener {
            registerUser()
        }
    }

    //método para fazer o cadastro do usuário e verificar se os campos estão preenchidos
    private fun registerUser() {
        val userName: String = userNameEditText.text.toString()
        val email: String = emailEditText.text.toString()
        val password: String = passwordEditText.text.toString()

        if (email.isEmpty() || userName.isEmpty() || password.isEmpty()) {
            toast("Preencha todos os campos!!!")
        } else {
            //Cria o usuário com o email ou senha
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        toast("Cadastro realizado com SUCESSO!!!")
                    }
                }.addOnFailureListener /*caso n cadastre o usuário gera uma toast de erro*/{
                    toast("Erro ao cadastrar o usuário x(")
                }
        }
    }
}