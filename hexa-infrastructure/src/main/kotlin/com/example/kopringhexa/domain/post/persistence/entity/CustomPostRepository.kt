package com.example.kopringhexa.domain.post.persistence.entity

import com.example.kopringhexa.domain.post.persistence.entity.vo.PostVo

interface CustomPostRepository {
    fun queryPost(title: String): List<PostVo>
}