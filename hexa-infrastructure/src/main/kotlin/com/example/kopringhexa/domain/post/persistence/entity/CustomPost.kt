package com.example.kopringhexa.domain.post.persistence.entity

import com.example.kopringhexa.domain.post.persistence.entity.vo.PostVo

interface CustomPost {
    fun queryPost(title: String): List<PostVo>
}