package com.example.kopringhexa.domain.post.persistence

import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.mapper.PostMapper
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.post.spi.PostSaveRepositorySpi
import org.springframework.stereotype.Repository

@Repository
class CustomPostRepositoryImpl(
        private val postMapper: PostMapper,
        private val postRepository: PostRepository
) : PostSaveRepositorySpi{
    override fun savePost(post: Post) {
        val postEntity: PostEntity = postMapper.postDomainToPostEntity(post)
        postRepository.save(postEntity)
    }
}