package com.example.kopringhexa.domain.post.persistence.entity.vo

import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import com.querydsl.core.annotations.QueryProjection

class PostVo @QueryProjection constructor(
        val title: String,
        val content: String,
        val userName: String
)