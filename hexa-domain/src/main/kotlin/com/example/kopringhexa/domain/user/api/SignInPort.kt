package com.example.kopringhexa.domain.user.api

import com.example.kopringhexa.domain.user.api.dto.SignInRequest

interface SignInPort {
    fun signIn(request:SignInRequest)
}