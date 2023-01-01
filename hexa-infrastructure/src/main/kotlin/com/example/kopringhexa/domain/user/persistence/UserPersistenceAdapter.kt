package com.example.kopringhexa.domain.user.persistence

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.exception.UserExistException
import com.example.kopringhexa.domain.user.exception.UserNotFoundException
import com.example.kopringhexa.domain.user.facade.UserFacade
import com.example.kopringhexa.domain.user.mapper.UserMapper
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import com.example.kopringhexa.domain.user.spi.PasswordChangeRepositorySpi
import com.example.kopringhexa.domain.user.spi.SaveUserRepositorySpi
import com.example.kopringhexa.domain.user.spi.SignInRepositorySpi
import com.example.kopringhexa.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
class UserPersistenceAdapter (
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val userFacade: UserFacade
): SaveUserRepositorySpi, SignInRepositorySpi, PasswordChangeRepositorySpi {

    @Transactional
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

    @Transactional
    override fun loginUser(user: User): TokenResponse {
        val userEntity = userFacade.getUserByName(user.name)

        if(!passwordEncoder.matches(user.password, userEntity.password)) {
            throw UserNotFoundException.EXCEPTION
        }

        return jwtTokenProvider.getToken(userEntity.name)
    }

    @Transactional
    override fun changePassword(name: String, password: String, newPassword: String) {
        val user = userFacade.getUserByName(name)

        if (user.password != password) {
            throw UserNotFoundException.EXCEPTION
        }

        user.updatePassword(passwordEncoder.encode(newPassword))
    }
}