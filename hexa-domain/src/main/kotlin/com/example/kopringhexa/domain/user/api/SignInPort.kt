package com.example.kopringhexa.domain.user.api

interface SignInPort {
    fun signIn(name: String, password: String)
}