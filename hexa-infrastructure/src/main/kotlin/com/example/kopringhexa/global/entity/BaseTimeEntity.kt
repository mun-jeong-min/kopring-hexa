package com.example.kopringhexa.global.entity

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity {

    val createdAt: LocalDateTime = LocalDateTime.now()
}