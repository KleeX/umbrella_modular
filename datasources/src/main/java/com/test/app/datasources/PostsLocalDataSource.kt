package com.test.app.datasources

import com.test.app.data.Post
import kotlinx.coroutines.flow.Flow

interface PostsLocalDataSource {
    val posts: Flow<List<Post>>
    val savedPostId: Int
    fun getPost(id: Int): Flow<Post?>
    suspend fun savePosts(posts: List<Post>)
    fun savePostId(id: Int)
}