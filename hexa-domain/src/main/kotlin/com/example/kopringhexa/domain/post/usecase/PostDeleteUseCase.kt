package com.example.kopringhexa.domain.post.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.post.api.PostDeletePort
import com.example.kopringhexa.domain.post.spi.PostDeleteRepositorySpi

@UseCase
class PostDeleteUseCase (
        private val postDeleteRepositorySpi: PostDeleteRepositorySpi
) : PostDeletePort {
    override fun deletePost(id: Long) {
        postDeleteRepositorySpi.deletePost(id)
    }
}