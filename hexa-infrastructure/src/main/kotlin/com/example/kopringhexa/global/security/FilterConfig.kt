package com.example.kopringhexa.global.security

import com.example.kopringhexa.global.error.ExceptionFilter
import com.example.kopringhexa.global.security.jwt.JwtTokenFilter
import com.example.kopringhexa.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig (
        private val objectMapper: ObjectMapper,
        private val jwtTokenProvider: JwtTokenProvider
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity?) {
        val jwtTokenFilter = JwtTokenFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)
        builder?.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder?.addFilterBefore(exceptionFilter, JwtTokenFilter::class.java)
    }
}