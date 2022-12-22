package com.example.kopringhexa.domain.user.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.user.api.SignInPort
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.spi.SaveUserRepositorySpi
import com.example.kopringhexa.domain.user.spi.UserJwtRepositorySpi

@UseCase
class SignInUseCase(
    private val saveUserRepositorySpi: SaveUserRepositorySpi,
    private val userJwtRepositorySpi: UserJwtRepositorySpi
) : SignInPort {
    override fun signIn(name: String, password: String): TokenResponse {
        val user: User = User(
                name = name,
                password = password
        )

        saveUserRepositorySpi.saveUser(user)

        return userJwtRepositorySpi.jwtUser(
                user = user
        )
    }
}