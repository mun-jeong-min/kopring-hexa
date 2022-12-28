package com.example.kopringhexa.domain.post.persistence

import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.dto.PostElementResponse
import com.example.kopringhexa.domain.post.dto.PostListResponse
import com.example.kopringhexa.domain.post.mapper.PostMapper
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.post.spi.PostSaveRepositorySpi
import com.example.kopringhexa.domain.post.spi.SearchPostRepositorySpi
import com.example.kopringhexa.domain.search.persistence.SearchRepository
import com.example.kopringhexa.domain.search.persistence.entity.SearchEntity
import com.example.kopringhexa.domain.user.facade.UserFacade
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class PostPersistenceAdapter(
        private val postMapper: PostMapper,
        private val postRepository: PostRepository,
        private val userFacade: UserFacade,
        private val searchRepository: SearchRepository
) : PostSaveRepositorySpi, SearchPostRepositorySpi {
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

    override fun searchPost(title: String): PostListResponse {
        val user = userFacade.getCurrentUser()

        val postList = postRepository.queryPost(title).map {
            PostElementResponse(
                    it.title,
                    it.content,
                    it.userName
            )
        }

        searchRepository.save(
                SearchEntity(user.id, title, 500000000)
        )

        return PostListResponse(
                postList,
                searchRepository.findByUserId(user.id)?.title ?: ""
        )
    }
}