package com.example.kopringhexa.global.security.jwt

import com.example.kopringhexa.domain.user.persistence.UserRepository
import com.example.kopringhexa.global.error.exception.InvalidJwtException
import com.example.kopringhexa.global.security.auth.AuthDetailService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
        private val userRepository: UserRepository,
        private val authDetailService: AuthDetailService,
        private val jwtProperties: JwtProperties
) {

    fun resolveToken(request: HttpServletRequest): String? {
        val token: String? = request.getHeader(jwtProperties.header)
        return parseToken(token)
    }

    private fun parseToken(token: String?): String? {
        return if(token != null && token.startsWith(jwtProperties.prefix)) {
            token.replace(jwtProperties.prefix, "")
        } else null
    }

    fun authentication(token: String): Authentication {
        val userDetails: UserDetails = authDetailService.loadUserByUsername(getTokenSubject(token))

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getTokenSubject(token: String): String {
        return getTokenBody(token).subject
    }

    private fun getTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                    .parseClaimsJwt(token).body
        } catch (e: Exception) {
            when(e) {
                is ExpiredJwtException -> throw com.example.kopringhexa.global.error.exception.ExpiredJwtException.EXCEPTION
                else -> throw InvalidJwtException.EXCEPTION
            }
        }
    }
}