package com.example.kopringhexa.domain.post.spi

import com.example.kopringhexa.annotation.Spi
import com.example.kopringhexa.domain.post.domain.Post

@Spi
interface PostSaveRepositorySpi {
    fun savePost(post: Post)
}