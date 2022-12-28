package com.example.kopringhexa.user

import com.example.kopringhexa.domain.user.domain.User
import com.example.kopringhexa.domain.user.dto.TokenResponse
import com.example.kopringhexa.domain.user.spi.SignInRepositorySpi
import com.example.kopringhexa.domain.user.usecase.SignInUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class LoginUserTest {

    @MockBean
    private lateinit var signInRepositorySpi: SignInRepositorySpi

    private lateinit var signInUseCase: SignInUseCase

    @BeforeEach
    fun setUp() {
        signInUseCase = SignInUseCase(
                signInRepositorySpi
        )
    }

    private val name = "문정민"
    private val password = "das"

    private val accessToken = "eyJ0eXBlIjoiYWNjZXNzIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiJzc3NzcyIsImlhdCI6MTY3MjEzNzU3MywiZXhwIjoxNjg0MTM3NTczfQ.M0z-PxGlq5azRKpnaUWbp1iCcrMkwdLF60MgRAFs55A"

    private val userStub by lazy {
        User(
                id = 0,
                name = name,
                password = password
        )
    }

    @Test
    fun 로그인_성공() {
        val response = TokenResponse(
                accessToken = accessToken
        )

        given(signInRepositorySpi.loginUser(userStub))
                .willReturn(response)

        signInUseCase.signIn(name, password)
    }
}