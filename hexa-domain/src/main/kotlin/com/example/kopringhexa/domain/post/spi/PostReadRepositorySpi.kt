package com.example.kopringhexa.domain.post.spi

import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.domain.post.dto.PostElementResponse

@Spi
interface PostReadRepositorySpi {
    fun readPost(id: Long): PostElementResponse
}