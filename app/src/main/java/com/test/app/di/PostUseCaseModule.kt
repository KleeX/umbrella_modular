package com.test.app.di

import com.test.app.api.PostsRemoteDataSourceImpl
import com.test.app.datasources.PostsLocalDataSource
import com.test.app.datasources.PostsRemoteDataSource
import com.test.app.repositories.PostsRepository
import com.test.app.repositories_impl.PostRepoImpl
import com.test.app.storage.PostsLocalDataSourceImpl
import com.test.app.usecases.GetDataUseCase
import com.test.app.usecases_impl.GetDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class PostUseCaseModule {

    @Binds
    abstract fun bindGetDataUseCase(getDataUseCaseImpl: GetDataUseCaseImpl): GetDataUseCase

    @Binds
    abstract fun bindPostsRepository(impl: PostRepoImpl): PostsRepository

    @Binds
    abstract fun bindPostLocalDataSource(impl: PostsLocalDataSourceImpl): PostsLocalDataSource

    @Binds
    abstract fun bindPostRemoteDataSource(impl: PostsRemoteDataSourceImpl): PostsRemoteDataSource
}
