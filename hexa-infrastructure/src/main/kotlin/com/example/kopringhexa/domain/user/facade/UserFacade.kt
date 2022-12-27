package com.example.kopringhexa.domain.user.facade

import com.example.kopringhexa.domain.user.exception.UserNotFoundException
import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade (
        private val userRepository: UserRepository
) {

    fun getCurrentUser(): UserEntity {
        val name = SecurityContextHolder.getContext().authentication.name
        return getUserByName(name)
    }

    fun getUserByName(name: String): UserEntity {
        return userRepository.findUserEntityByName(name) ?: throw UserNotFoundException.EXCEPTION
    }
}