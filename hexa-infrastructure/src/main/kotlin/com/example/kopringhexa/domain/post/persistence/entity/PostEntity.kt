package com.example.kopringhexa.domain.post.persistence.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_post")
class PostEntity(
    title: String,

    content: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @NotNull
    var title = title
        protected set

    @NotNull
    var content = content
        protected set
}