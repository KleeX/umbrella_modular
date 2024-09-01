package com.test.app.usecases_impl

import com.test.app.data.Post
import com.test.app.repositories.PostsRepository
import com.test.app.usecases.GetDataUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataUseCaseImpl @Inject constructor(private val postRepo: PostsRepository) :
    GetDataUseCase {

    override fun invoke(): Flow<List<Post>> {
        return postRepo.getPosts()
    }
}