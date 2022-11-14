package com.example.kopringhexa.domain.user.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.user.api.SignInPort
import com.example.kopringhexa.domain.user.api.dto.SignInRequest
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.spi.SaveUserRepositorySpi

@UseCase
class SignInUseCase(
    private val saveUserRepositorySpi: SaveUserRepositorySpi
):SignInPort {
    override fun signIn(request: SignInRequest) {
        saveUserRepositorySpi.saveUser(
            User(
                name = request.name,
                password = request.password
            )
        )
    }
}