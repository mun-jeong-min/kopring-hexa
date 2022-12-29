package com.example.kopringhexa.domain.post.api

import com.example.kopringhexa.domain.post.dto.PostElementResponse

interface PostReadPort {
    fun readPost(id: Long): PostElementResponse
}