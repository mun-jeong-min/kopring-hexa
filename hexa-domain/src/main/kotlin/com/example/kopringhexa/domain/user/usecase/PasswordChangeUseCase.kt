package com.example.kopringhexa.domain.user.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.user.api.PasswordChangePort
import com.example.kopringhexa.domain.user.spi.PasswordChangeRepositorySpi

@UseCase
class PasswordChangeUseCase (
        private val passwordChangeRepositorySpi: PasswordChangeRepositorySpi
) : PasswordChangePort {
    override fun changePassword(name: String, password: String, newPassword: String) {
        passwordChangeRepositorySpi.changePassword(name, password, newPassword)
    }

}