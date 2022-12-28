package com.example.kopringhexa.domain.post.dto

data class PostListResponse (
        val postList: List<PostElementResponse>,
        val lastSearchTitle: String
)