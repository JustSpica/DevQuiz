package com.example.devquiz.model

class User {
    lateinit var userName: String
    lateinit var password: String
    lateinit var email: String

    override fun toString(): String {
        return "UserName: $userName" +
                "Password: $password" +
                "Email: $email"
    }
}