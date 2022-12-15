package com.example.kopringhexa.domain.user.presentation.dto.request

import javax.validation.constraints.NotNull

class WebSignInRequest {

    @NotNull
    lateinit var name: String
        private set

    @NotNull
    lateinit var password: String
        private set
}