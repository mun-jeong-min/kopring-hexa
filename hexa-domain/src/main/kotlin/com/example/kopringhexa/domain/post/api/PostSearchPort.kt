package com.example.kopringhexa.domain.post.api

import com.example.kopringhexa.domain.post.dto.PostListResponse

interface PostSearchPort {
    fun searchPost(title: String): PostListResponse
}