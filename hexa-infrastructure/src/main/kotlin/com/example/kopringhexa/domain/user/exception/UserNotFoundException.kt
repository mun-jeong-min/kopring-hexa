package com.example.kopringhexa.domain.user.exception

import com.example.kopringhexa.global.error.custom.CustomException
import com.example.kopringhexa.global.error.custom.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = UserNotFoundException
}