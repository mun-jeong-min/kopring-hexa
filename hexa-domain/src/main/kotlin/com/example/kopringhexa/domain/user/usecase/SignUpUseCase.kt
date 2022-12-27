package com.example.kopringhexa.domain.user.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.user.api.SignUpPort
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.spi.SaveUserRepositorySpi

@UseCase
class SignUpUseCase(
    private val saveUserRepositorySpi: SaveUserRepositorySpi
) : SignUpPort {
    override fun signup(name: String, password: String) {
        val user = User(
                name = name,
                password = password
        )

        saveUserRepositorySpi.saveUser(user)
    }
}