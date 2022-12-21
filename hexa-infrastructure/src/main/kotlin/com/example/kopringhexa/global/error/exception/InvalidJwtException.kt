package com.example.kopringhexa.global.error.exception

import com.example.kopringhexa.global.error.custom.CustomException
import com.example.kopringhexa.global.error.custom.ErrorCode

object InvalidJwtException : CustomException(ErrorCode.INVALID_JWT_EXCEPTION) {
    val EXCEPTION = InvalidJwtException
}