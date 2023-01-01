package com.example.kopringhexa.domain.user.presentation

import com.example.kopringhexa.domain.user.api.PasswordChangePort
import com.example.kopringhexa.domain.user.api.SignInPort
import com.example.kopringhexa.domain.user.api.SignUpPort
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.presentation.dto.request.ChangePasswordRequest
import com.example.kopringhexa.domain.user.presentation.dto.request.WebSignInRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserAdapter(
    private val signUpPort: SignUpPort,
    private val signInPort: SignInPort,
    private val passwordChangePort: PasswordChangePort
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun saveUser(@RequestBody request: WebSignInRequest) {
        signUpPort.signup(
            name = request.name,
            password = request.password
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign")
    fun loginUser(@RequestBody request: WebSignInRequest): TokenResponse {
        return signInPort.signIn(
                name = request.name,
                password = request.password
        )
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun changePassword(@RequestBody request: ChangePasswordRequest) {
        passwordChangePort.changePassword(
                request.name,
                request.password,
                request.newPassword
        )
    }
}