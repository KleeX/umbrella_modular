package com.test.app.api

import com.test.app.data.Post
import retrofit2.http.GET

interface PostsAPI {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(id: Int): Post
}