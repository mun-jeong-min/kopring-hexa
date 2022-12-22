package com.example.kopringhexa.domain.user.presentation

import com.example.kopringhexa.domain.user.api.SignInPort
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.presentation.dto.request.WebSignInRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserAdapter(
    private val signInPort: SignInPort
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun saveUser(@RequestBody request: WebSignInRequest): TokenResponse {
        return signInPort.signIn(
            name = request.name,
            password = request.password
        )
    }
}