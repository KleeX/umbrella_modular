package com.test.app.datasources

import com.test.app.data.Post

interface PostsRemoteDataSource {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post
}