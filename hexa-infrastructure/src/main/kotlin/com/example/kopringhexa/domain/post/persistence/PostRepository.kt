package com.example.kopringhexa.domain.post.persistence

import com.example.kopringhexa.domain.post.persistence.entity.PostEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : CrudRepository<PostEntity, Long> {
}