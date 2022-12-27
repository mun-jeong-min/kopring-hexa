package com.example.kopringhexa.domain.post.mapper

import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.persistence.PostRepository
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.user.exception.UserNotFoundException
import com.example.kopringhexa.domain.user.persistence.UserRepository
import org.springframework.stereotype.Component

@Component
class PostMapperImpl(
        private val userRepository: UserRepository
) : PostMapper {
    override fun postEntityToDomain(postEntity: PostEntity): Post {
        return Post(
                id = postEntity.id,
                title = postEntity.title,
                content = postEntity.content,
                userId = postEntity.userEntity.id
        )
    }

    override fun postDomainToPostEntity(post: Post): PostEntity {
        val user = userRepository.findUserEntityById(post.userId) ?: throw UserNotFoundException

        return PostEntity(
                title = post.title,
                content = post.content,
                userEntity = user
        )
    }
}