package com.example.kopringhexa.domain.user.api

import com.example.kopringhexa.domain.user.dto.TokenResponse

interface SignInPort {
    fun signIn(name: String, password: String): TokenResponse
}