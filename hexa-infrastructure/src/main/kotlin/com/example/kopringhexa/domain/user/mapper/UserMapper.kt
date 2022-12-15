package com.example.kopringhexa.domain.user.mapper

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity

interface UserMapper {
    fun userDomainToEntity(user: User): UserEntity
    fun userEntityToDomain(userEntity: UserEntity): User
}