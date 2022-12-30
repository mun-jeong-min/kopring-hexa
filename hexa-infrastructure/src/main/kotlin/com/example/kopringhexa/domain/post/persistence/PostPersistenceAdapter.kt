package com.example.kopringhexa.domain.post.persistence

import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.dto.PostElementResponse
import com.example.kopringhexa.domain.post.dto.PostListResponse
import com.example.kopringhexa.domain.post.exception.PostNotFoundException
import com.example.kopringhexa.domain.post.facade.PostFacade
import com.example.kopringhexa.domain.post.mapper.PostMapper
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.post.spi.*
import com.example.kopringhexa.domain.search.persistence.SearchRepository
import com.example.kopringhexa.domain.search.persistence.entity.SearchEntity
import com.example.kopringhexa.domain.user.facade.UserFacade
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class PostPersistenceAdapter(
        private val postMapper: PostMapper,
        private val postRepository: PostRepository,
        private val userFacade: UserFacade,
        private val searchRepository: SearchRepository,
        private val postFacade: PostFacade
) : PostSaveRepositorySpi, SearchPostRepositorySpi, PostReadRepositorySpi, PostUpdateRepositorySpi, PostDeleteRepositorySpi {

    @Transactional
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

    @Transactional
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

    @Transactional
    override fun readPost(id: Long): PostElementResponse {
        val post = postFacade.getPost(id)
        val name = post.userEntity.name

        return PostElementResponse(
                post.title,
                post.content,
                name
        )
    }

    @Transactional
    override fun updatePost(id: Long, title: String, content: String) {
        val post = postFacade.getPost(id)

        post.updatePost(title, content)
    }

    @Transactional
    override fun deletePost(id: Long) {
        postRepository.delete(postFacade.getPost(id))
    }
}