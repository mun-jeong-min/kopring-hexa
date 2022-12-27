package com.example.kopringhexa.domain.user.api

interface SignUpPort {
    fun signup(name: String, password: String)
}