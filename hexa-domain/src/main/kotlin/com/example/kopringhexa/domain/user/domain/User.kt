package com.example.kopringhexa.domain.user.domain

import com.example.kopringhexa.annotation.Aggregate

@Aggregate
class User(
    val id: Long = 0,

    val name: String,

    val password: String
)