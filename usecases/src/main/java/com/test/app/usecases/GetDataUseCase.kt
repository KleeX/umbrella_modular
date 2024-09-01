package com.test.app.usecases

import com.test.app.data.Post
import kotlinx.coroutines.flow.Flow

interface GetDataUseCase {
    operator fun invoke(): Flow<List<Post>>
}