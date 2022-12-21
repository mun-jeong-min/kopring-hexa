package com.example.kopringhexa.global.error

import com.example.kopringhexa.global.error.custom.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CustomException::class)
    fun of(e: CustomException): ResponseEntity<ErrorResponse<Unit>> {
        return ResponseEntity(ErrorResponse.of(e), HttpStatus.valueOf(e.status))
    }
}