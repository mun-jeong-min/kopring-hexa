package com.example.kopringhexa.domain.post.spi

import com.example.kopringhexa.annotation.Spi

@Spi
interface PostUpdateRepositorySpi {
    fun updatePost(id: Long, title: String, content: String)
}