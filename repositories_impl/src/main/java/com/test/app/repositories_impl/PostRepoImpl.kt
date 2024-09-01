package com.test.app.repositories_impl

import com.test.app.data.Post
import com.test.app.datasources.PostsLocalDataSource
import com.test.app.datasources.PostsRemoteDataSource
import com.test.app.repositories.PostsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PostRepoImpl @Inject constructor(
    private val postApi: PostsRemoteDataSource,
    private val postLocalDS: PostsLocalDataSource
) : PostsRepository {

    override fun getPosts(): Flow<List<Post>> {
        return postLocalDS.posts.onStart {
            val posts = postApi.getPosts()
            postLocalDS.savePosts(posts)
        }
    }

    override fun getPost(id: Int): Flow<Post?> {
        return postLocalDS.getPost(id)
    }

    override fun savePostId(id: Int) {
        postLocalDS.savePostId(id)
    }

    override val postId: Int
        get() = postLocalDS.savedPostId

}