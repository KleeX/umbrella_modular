package com.test.app.test_feature

import androidx.lifecycle.ViewModel
import com.test.app.data.Post
import com.test.app.usecases.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(getDataUseCase: GetDataUseCase) :
    ViewModel() {

    var posts: Flow<List<Post>> = getDataUseCase()
}