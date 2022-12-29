package com.example.kopringhexa.domain.post.presentation

import com.example.kopringhexa.domain.post.api.PostReadPort
import com.example.kopringhexa.domain.post.api.PostSavePort
import com.example.kopringhexa.domain.post.api.PostSearchPort
import com.example.kopringhexa.domain.post.dto.PostElementResponse
import com.example.kopringhexa.domain.post.dto.PostListResponse
import com.example.kopringhexa.domain.post.presentation.dto.request.PostSaveRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostAdapter(
        private val postSavePort: PostSavePort,
        private val postSearchPort: PostSearchPort,
        private val postReadPort: PostReadPort
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun savePost(@RequestBody postSaveRequest: PostSaveRequest) {
        postSavePort.savePost(
                title = postSaveRequest.title,
                content = postSaveRequest.content
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun searchPost(@RequestParam(name = "title", required = false, defaultValue = "") title: String): PostListResponse {
        return postSearchPort.searchPost(
                title
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    fun readPost(@PathVariable("id") id: Long): PostElementResponse {
        return postReadPort.readPost(id)
    }
}