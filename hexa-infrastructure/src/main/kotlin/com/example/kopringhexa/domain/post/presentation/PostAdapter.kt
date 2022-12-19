package com.example.kopringhexa.domain.post.presentation

import com.example.kopringhexa.domain.post.api.PostSavePort
import com.example.kopringhexa.domain.post.presentation.dto.request.PostSaveRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostAdapter(
        private val postSavePort: PostSavePort
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun savePost(@RequestBody postSaveRequest: PostSaveRequest) {
        postSavePort.savePost(
                title = postSaveRequest.title,
                content = postSaveRequest.content
        )
    }
}