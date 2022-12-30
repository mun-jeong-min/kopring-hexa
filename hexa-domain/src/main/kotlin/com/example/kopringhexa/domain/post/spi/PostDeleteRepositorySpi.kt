package com.example.kopringhexa.domain.post.spi

import com.example.kopringhexa.annotation.Spi

@Spi
interface PostDeleteRepositorySpi {
    fun deletePost(id: Long)
}