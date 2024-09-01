package com.test.app.repositories

import com.test.app.data.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): Flow<List<Post>>
    fun getPost(id: Int): Flow<Post?>
    fun savePostId(id: Int)
    val postId: Int
}