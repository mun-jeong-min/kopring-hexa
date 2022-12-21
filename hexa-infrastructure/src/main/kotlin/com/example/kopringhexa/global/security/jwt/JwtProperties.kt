package com.example.kopringhexa.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtProperties (
        val secretKey: String,
        val accessExp: Long,
        val refreshExp: Long,
        val header: String,
        val prefix: String
)