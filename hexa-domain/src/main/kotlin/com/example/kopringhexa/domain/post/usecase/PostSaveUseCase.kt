package com.example.kopringhexa.domain.post.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.post.api.PostSavePort
import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.spi.PostSaveRepositorySpi

@UseCase
class PostSaveUseCase(
        private val postSaveSpi: PostSaveRepositorySpi
): PostSavePort {
    override fun savePost(title: String, content: String) {
        postSaveSpi.savePost(
                Post(
                        title = title,
                        content = content
                )
        )
    }
}