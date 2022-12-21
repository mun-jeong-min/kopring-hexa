package com.example.kopringhexa.global.error

import com.example.kopringhexa.global.error.custom.CustomException
import org.springframework.web.bind.MethodArgumentNotValidException

class ErrorResponse<T> (
        val status: Int,
        val message: String,
) {
    companion object {
        fun of(e: CustomException): ErrorResponse<Unit> = ErrorResponse(
                status = e.status,
                message = e.errorMessage
        )
    }
}