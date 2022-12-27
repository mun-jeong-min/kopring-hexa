package com.example.kopringhexa.domain.user.persistence

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.exception.UserExistException
import com.example.kopringhexa.domain.user.exception.UserNotFoundException
import com.example.kopringhexa.domain.user.mapper.UserMapper
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import com.example.kopringhexa.domain.user.spi.SaveUserRepositorySpi
import com.example.kopringhexa.domain.user.spi.SignInRepositorySpi
import com.example.kopringhexa.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class CustomUserRepositoryImpl (
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
): SaveUserRepositorySpi, SignInRepositorySpi {

    override fun saveUser(user: User) {

        val users = User(
                name = user.name,
                password = passwordEncoder.encode(user.password)
        )

        val userEntity : UserEntity = userMapper.userDomainToEntity(users)

        userRepository.findUserEntityByName(userEntity.name).let {
            if(it != null) { throw UserExistException.EXCEPTION }
        }

        userRepository.save(userEntity)
    }

    override fun loginUser(user: User): TokenResponse {
        val userEntity: UserEntity = userRepository.findUserEntityByName(user.name) ?: throw UserNotFoundException.EXCEPTION

        if(!passwordEncoder.matches(user.password, userEntity.password)) {
            throw UserNotFoundException.EXCEPTION
        }

        return jwtTokenProvider.getToken(userEntity.name)
    }
}