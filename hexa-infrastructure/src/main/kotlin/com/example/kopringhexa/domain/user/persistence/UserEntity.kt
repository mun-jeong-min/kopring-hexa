package com.example.kopringhexa.domain.user.persistence

import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "tbl_user")
@Entity
class UserEntity(
    name: String,

    password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @NotNull
    var name = name
        protected set

    @NotNull
    var password = password
        protected set
}