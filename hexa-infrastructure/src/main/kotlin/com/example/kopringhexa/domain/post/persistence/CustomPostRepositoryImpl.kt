package com.example.kopringhexa.domain.post.persistence

import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.mapper.PostMapper
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.post.spi.PostSaveRepositorySpi
import com.example.kopringhexa.domain.user.facade.UserFacade
import org.springframework.stereotype.Repository

@Repository
class CustomPostRepositoryImpl(
        private val postMapper: PostMapper,
        private val postRepository: PostRepository,
        private val userFacade: UserFacade
) : PostSaveRepositorySpi{
    override fun savePost(post: Post) {
        val userEntity = userFacade.getCurrentUser()

        val posts = Post(
                userId = userEntity.id,
                title = post.title,
                content = post.content
        )

        val postEntity: PostEntity = postMapper.postDomainToPostEntity(posts)
        postRepository.save(postEntity)
    }
}