package com.example.kopringhexa.global.security.auth

import com.example.kopringhexa.domain.user.exception.UserNotFoundException
import com.example.kopringhexa.domain.user.persistence.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class AuthDetailService(
        private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return AuthDetails(
                userRepository.findUserEntityByName(username) ?: throw UserNotFoundException.EXCEPTION
        )
    }
}