package com.example.kopringhexa.domain.post.persistence.entity

import com.example.kopringhexa.domain.user.persistence.entity.UserEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_post")
class PostEntity(
    title: String,

    content: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity
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

    fun updatePost(title: String, content: String) {
        this.title = title
        this.content = content
    }
}