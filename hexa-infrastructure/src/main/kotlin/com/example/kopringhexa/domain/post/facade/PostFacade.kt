package com.example.kopringhexa.domain.post.facade

import com.example.kopringhexa.domain.post.exception.PostNotFoundException
import com.example.kopringhexa.domain.post.persistence.PostRepository
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import org.springframework.stereotype.Component

@Component
class PostFacade (
        private val postRepository: PostRepository
) {

    fun getPost(id: Long): PostEntity {
        return postRepository.findPostEntityById(id) ?: throw PostNotFoundException.EXCEPTION
    }
}