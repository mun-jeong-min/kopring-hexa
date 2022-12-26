package com.example.kopringhexa.domain.user.api

import com.example.kopringhexa.domain.user.dto.TokenResponse

interface SignUpPort {
    fun signup(name: String, password: String): TokenResponse
}