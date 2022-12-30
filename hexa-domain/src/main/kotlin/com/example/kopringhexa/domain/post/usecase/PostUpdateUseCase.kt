package com.example.kopringhexa.domain.post.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.post.api.PostUpdatePort
import com.example.kopringhexa.domain.post.spi.PostUpdateRepositorySpi

@UseCase
class PostUpdateUseCase (
        private val postUpdateRepositorySpi: PostUpdateRepositorySpi
) : PostUpdatePort{
    override fun updatePost(id: Long, title: String, content: String) {
        postUpdateRepositorySpi.updatePost(id, title, content)
    }
}