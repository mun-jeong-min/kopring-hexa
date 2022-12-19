package com.example.kopringhexa.domain.post.presentation.dto.request

import javax.validation.constraints.NotNull

class PostSaveRequest {

    @NotNull
    lateinit var title: String
        private set

    @NotNull
    lateinit var content: String
        private set
}