package com.example.kopringhexa.domain.post.api

interface PostUpdatePort {
    fun updatePost(id : Long, title: String, content: String)
}