package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.exception.UserExistException
import com.example.kopringhexa.domain.user.mapper.UserMapper
import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import com.example.kopringhexa.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Repository

@Repository
class SaveUserRepositoryImpl (
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider
): SaveUserRepositorySpi {

    override fun saveUser(user: User) {
        val userEntity = userMapper.userDomainToEntity(user)

        userRepository.save(userEntity)
    }

    override fun jwtUser(user: User): TokenResponse {
        val userEntity: UserEntity = userMapper.userDomainToEntity(user)

        return jwtTokenProvider.getToken(userEntity.name)
    }

    override fun checkUser(user: User) {
        val userEntity = userMapper.userDomainToEntity(user)

        if (userRepository.findUserEntityByName(user.name).name == userEntity.name) {
            throw UserExistException.EXCEPTION
        }
    }
}