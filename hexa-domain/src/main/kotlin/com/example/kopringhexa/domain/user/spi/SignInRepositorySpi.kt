package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse

@Spi
interface SignInRepositorySpi {
    fun loginUser(user: User): TokenResponse
}