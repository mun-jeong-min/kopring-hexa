package com.example.kopringhexa.domain.search.persistence

import com.example.kopringhexa.domain.search.persistence.entity.SearchEntity
import org.springframework.data.repository.CrudRepository

interface SearchRepository : CrudRepository<SearchEntity, Long> {
    fun findByUserId(userId: Long): SearchEntity?
}