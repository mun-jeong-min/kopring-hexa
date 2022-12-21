package com.example.kopringhexa.domain.user.persistence

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findUserEntityByName(name: String): UserEntity
}