package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.mapper.UserMapper
import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import com.example.kopringhexa.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Repository

@Repository
class JwtUserRepositoryImpl (
        private val userMapper: UserMapper,
        private val jwtTokenProvider: JwtTokenProvider
) : UserJwtRepositorySpi {
    override fun jwtUser(user: User): TokenResponse {
        val userEntity: UserEntity = userMapper.userDomainToEntity(user)

        return jwtTokenProvider.getToken(userEntity.name)
    }
}