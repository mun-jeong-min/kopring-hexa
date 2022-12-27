package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.exception.UserNotFoundException
import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import com.example.kopringhexa.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class SignInRepositoryImpl (
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val jwtTokenProvider: JwtTokenProvider
) : SignInRepositorySpi {
    override fun loginUser(user: User): TokenResponse {
        val userEntity: UserEntity = userRepository.findUserEntityByName(user.name) ?: throw UserNotFoundException.EXCEPTION

        if(!passwordEncoder.matches(user.password, userEntity.password)) {
            throw UserNotFoundException.EXCEPTION
        }

        return jwtTokenProvider.getToken(userEntity.name)
    }
}