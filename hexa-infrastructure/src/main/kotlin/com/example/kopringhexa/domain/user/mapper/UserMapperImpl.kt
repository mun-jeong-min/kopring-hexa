package com.example.kopringhexa.domain.user.mapper

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapperImpl(
    private val userRepository: UserRepository
) : UserMapper{
    override fun userDomainToEntity(user: User): UserEntity {
        return UserEntity(
            password = user.password,
            name = user.name
        )
    }

    override fun userEntityToDomain(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            name = userEntity.name,
            password = userEntity.password
        )
    }
}