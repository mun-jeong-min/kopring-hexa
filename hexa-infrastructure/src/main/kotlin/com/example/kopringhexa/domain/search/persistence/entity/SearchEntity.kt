package com.example.kopringhexa.domain.search.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import javax.validation.constraints.NotBlank

@RedisHash(value = "search")
class SearchEntity (
        @Id
        @Indexed
        val userId: Long,

        @NotBlank
        val title: String,

        @TimeToLive
        val timeToLive: Long
)