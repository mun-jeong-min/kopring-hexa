package com.example.kopringhexa.domain.user.presentation.dto.request

data class ChangePasswordRequest(
        val name: String,
        val password: String,
        val newPassword: String
)
