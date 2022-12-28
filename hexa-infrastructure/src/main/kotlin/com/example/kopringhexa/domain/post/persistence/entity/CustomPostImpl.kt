package com.example.kopringhexa.domain.post.persistence.entity

import com.example.kopringhexa.domain.post.persistence.entity.vo.PostVo
import com.example.kopringhexa.domain.post.persistence.entity.vo.QPostVo
import com.example.kopringhexa.domain.user.persistence.entity.QUserEntity.userEntity
import com.example.kopringhexa.domain.post.persistence.entity.QPostEntity.postEntity
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomPostImpl(
        private val query: JPAQueryFactory
) : CustomPost {
    override fun queryPost(title: String): List<PostVo> {
        return query.select(
                QPostVo(
                        postEntity.title,
                        postEntity.content,
                        userEntity.name
                ),
        ).from(postEntity)
                .where(postEntity.title.contains(title))
                .leftJoin(postEntity.userEntity, userEntity)
                .orderBy(userEntity.id.asc())
                .fetch()
    }
}