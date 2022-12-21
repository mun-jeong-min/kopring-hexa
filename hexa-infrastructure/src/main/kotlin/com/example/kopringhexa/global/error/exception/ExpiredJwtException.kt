package com.example.kopringhexa.global.error.exception

import com.example.kopringhexa.global.error.custom.CustomException
import com.example.kopringhexa.global.error.custom.ErrorCode

object ExpiredJwtException : CustomException(ErrorCode.EXPIRED_JWT_EXCEPTION) {
    val EXCEPTION = ExpiredJwtException
}