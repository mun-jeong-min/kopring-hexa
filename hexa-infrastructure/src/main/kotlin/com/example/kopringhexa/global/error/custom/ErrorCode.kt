package com.example.kopringhexa.global.error.custom

import org.springframework.http.HttpStatus

enum class ErrorCode (
        private val status: HttpStatus,
        private val message: String
) : ErrorProperty {
    USER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "user not found"),
    POST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "post not found"),

    INVALID_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED, "invalid jwt"),
    EXPIRED_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED, "Expired jwt"),

    USER_EXIST(HttpStatus.CONFLICT, "User Exists"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "server error");

    override fun status() = status.value()
    override fun message() = message
}