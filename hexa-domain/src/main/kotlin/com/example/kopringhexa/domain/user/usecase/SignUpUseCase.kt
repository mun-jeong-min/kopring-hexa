package com.example.kopringhexa.domain.user.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.user.api.SignUpPort
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.spi.SaveUserRepositorySpi
import com.example.kopringhexa.domain.user.spi.UserJwtRepositorySpi

@UseCase
class SignUpUseCase(
    private val saveUserRepositorySpi: SaveUserRepositorySpi,
    private val userJwtRepositorySpi: UserJwtRepositorySpi,
) : SignUpPort {
    override fun signup(name: String, password: String): TokenResponse {
        val user = User(
                name = name,
                password = password
        )

        saveUserRepositorySpi.checkUser(user)

        saveUserRepositorySpi.saveUser(user)

        return saveUserRepositorySpi.jwtUser(
                user = user
        )
    }
}