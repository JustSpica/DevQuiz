package com.example.devquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    private val buttonLogout by lazy { findViewById<Button>(R.id.button2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        buttonLogout.setOnClickListener{
            auth?.signOut()
            finish()
        }

    }
}