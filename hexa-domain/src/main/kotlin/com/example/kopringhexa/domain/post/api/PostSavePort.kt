package com.example.kopringhexa.domain.post.api

interface PostSavePort {
    fun savePost(title: String, content: String)
}