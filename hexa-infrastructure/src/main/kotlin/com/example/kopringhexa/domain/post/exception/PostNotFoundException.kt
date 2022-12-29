package com.example.kopringhexa.domain.post.exception

import com.example.kopringhexa.global.error.custom.CustomException
import com.example.kopringhexa.global.error.custom.ErrorCode

object PostNotFoundException : CustomException(ErrorCode.POST_NOT_FOUND_EXCEPTION) {
    val EXCEPTION = PostNotFoundException
}