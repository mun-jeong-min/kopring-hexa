package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse

@Spi
interface SaveUserRepositorySpi {
    fun saveUser(user: User)

    fun jwtUser(user: User): TokenResponse

    fun checkUser(user: User)
}