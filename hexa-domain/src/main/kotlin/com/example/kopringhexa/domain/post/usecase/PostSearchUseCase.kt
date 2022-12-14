package com.example.kopringhexa.domain.post.usecase

import com.example.kopringhexa.annotation.UseCase
import com.example.kopringhexa.domain.post.api.PostSearchPort
import com.example.kopringhexa.domain.post.dto.PostListResponse
import com.example.kopringhexa.domain.post.spi.SearchPostRepositorySpi

@UseCase
class PostSearchUseCase (
        private val postSearchSpi: SearchPostRepositorySpi
) : PostSearchPort {
    override fun searchPost(title: String): PostListResponse {
        return postSearchSpi.searchPost(
                title
        )
    }
}