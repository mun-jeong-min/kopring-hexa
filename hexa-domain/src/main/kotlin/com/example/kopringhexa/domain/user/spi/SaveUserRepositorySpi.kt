package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.domain.user.domain.User

@Spi
interface SaveUserRepositorySpi {
    fun saveUser(user: User)
}