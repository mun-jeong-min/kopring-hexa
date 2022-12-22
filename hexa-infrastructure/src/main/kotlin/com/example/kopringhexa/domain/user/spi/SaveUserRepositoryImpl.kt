package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.mapper.UserMapper
import com.example.kopringhexa.domain.user.persistence.UserRepository
import org.springframework.stereotype.Repository

@Repository
class SaveUserRepositoryImpl (
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
): SaveUserRepositorySpi {

    override fun saveUser(user: User) {
        val userEntity = userMapper.userDomainToEntity(user)
        userRepository.save(userEntity)
    }
}