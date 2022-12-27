package com.example.kopringhexa.domain.user.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.user.api.SignInPort
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.spi.SignInRepositorySpi

@UseCase
class SignInUseCase (
        private val signInRepositorySpi: SignInRepositorySpi
) : SignInPort {
    override fun signIn(name: String, password: String): TokenResponse {
        val user = User(
                name = name,
                password = password
        )

        return signInRepositorySpi.loginUser(
                user = user
        )
    }
}