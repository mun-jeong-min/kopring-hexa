package com.example.kopringhexa.domain.post.spi

import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.dto.PostListResponse

@Spi
interface SearchPostRepositorySpi {
    fun searchPost(title: String): PostListResponse
}