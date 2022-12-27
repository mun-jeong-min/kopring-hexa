package com.example.kopringhexa.domain.post.domain

import com.example.kopringhexa.annotation.Aggregate

@Aggregate
class Post (
    val id: Long = 0,

    val title: String,

    val content: String,

    val userId: Long = 0
)