package com.example.kopringhexa.domain.user.api

interface PasswordChangePort {
    fun changePassword(name: String, password: String, newPassword: String)
}