package com.example.kopringhexa.domain.post.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.post.api.PostReadPort
import com.example.kopringhexa.domain.post.dto.PostElementResponse
import com.example.kopringhexa.domain.post.spi.PostReadRepositorySpi

@UseCase
class PostReadUseCase (
        private val postReadRepositorySpi: PostReadRepositorySpi
) : PostReadPort {
    override fun readPost(id: Long): PostElementResponse {
        return postReadRepositorySpi.readPost(id)
    }
}