package com.example.kopringhexa.global.error.exception

import com.example.kopringhexa.global.error.custom.CustomException
import com.example.kopringhexa.global.error.custom.ErrorCode

object InternalServerException : CustomException(ErrorCode.INTERNAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerException
}