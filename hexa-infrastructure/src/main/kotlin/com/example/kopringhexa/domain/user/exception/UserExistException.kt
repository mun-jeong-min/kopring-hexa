package com.example.kopringhexa.domain.user.exception

import com.example.kopringhexa.global.error.custom.CustomException
import com.example.kopringhexa.global.error.custom.ErrorCode

object UserExistException : CustomException(ErrorCode.USER_EXIST) {
    val EXCEPTION = UserExistException
}