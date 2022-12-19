package com.example.kopringhexa.domain.post.mapper

import com.example.kopringhexa.domain.post.domain.Post
import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity

interface PostMapper {
    fun postEntityToDomain(postEntity: PostEntity): Post
    fun postDomainToPostEntity(post: Post): PostEntity
}