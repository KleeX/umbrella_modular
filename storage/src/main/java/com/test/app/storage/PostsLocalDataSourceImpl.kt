package com.test.app.storage

import com.test.app.data.Post
import com.test.app.datasources.PostsLocalDataSource
import com.test.app.storage.db.PostDao
import com.test.app.storage.mappers.toPost
import com.test.app.storage.mappers.toPostEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostsLocalDataSourceImpl @Inject constructor(
    private val postDao: PostDao
) : PostsLocalDataSource {

    override val posts
        get() = postDao.getAllPosts().map {
            it.map { postEntity -> postEntity.toPost() }
        }

    override val savedPostId: Int
        get() = postId

    private var postId: Int = -1

    override fun getPost(id: Int): Flow<Post?> =
        postDao.getPostById(id).map { it?.toPost() }

    override suspend fun savePosts(posts: List<Post>) {
        postDao.updatePosts(posts.map { it.toPostEntity() })
    }

    override fun savePostId(id: Int) {
        postId = id
    }
}