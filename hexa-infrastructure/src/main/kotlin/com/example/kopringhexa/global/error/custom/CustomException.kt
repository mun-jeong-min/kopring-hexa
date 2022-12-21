package com.example.kopringhexa.global.error.custom

import java.lang.RuntimeException

open class CustomException (
    private val errorProperty: ErrorProperty
) : RuntimeException() {
    val status: Int
        get() = errorProperty.status()

    val errorMessage: String
        get() = errorProperty.message()
}