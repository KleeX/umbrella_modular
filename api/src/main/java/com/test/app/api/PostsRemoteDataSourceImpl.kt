package com.test.app.api

import com.test.app.data.Post
import com.test.app.datasources.PostsRemoteDataSource
import javax.inject.Inject

class PostsRemoteDataSourceImpl @Inject constructor(private val postsAPI: PostsAPI) : PostsRemoteDataSource {

    override suspend fun getPosts(): List<Post> = postsAPI.getPosts()

    override suspend fun getPost(id: Int): Post = postsAPI.getPost(id)
}