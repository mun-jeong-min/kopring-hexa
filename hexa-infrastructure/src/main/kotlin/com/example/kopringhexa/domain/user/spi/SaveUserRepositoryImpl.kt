package com.example.kopringhexa.domain.user.spi

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.exception.UserExistException
import com.example.kopringhexa.domain.user.mapper.UserMapper
import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import org.mapstruct.control.MappingControl.Use
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class SaveUserRepositoryImpl (
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
): SaveUserRepositorySpi {

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
}