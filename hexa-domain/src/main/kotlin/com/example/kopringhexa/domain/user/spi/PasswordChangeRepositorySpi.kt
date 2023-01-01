package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.annotation.Spi

@Spi
interface PasswordChangeRepositorySpi {
    fun changePassword(name: String, password: String, newPassword: String)
}