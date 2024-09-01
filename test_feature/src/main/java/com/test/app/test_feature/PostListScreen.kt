package com.test.app.test_feature

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

//val LocalNavController = staticCompositionLocalOf<NavController> {
//    error("CompositionLocal LocalNavController not present")
//}

@Composable
fun PostListScreen() {
    val viewModel = hiltViewModel<PostListViewModel>()
//    val navController = LocalNavController.current
    val posts = viewModel.posts.collectAsState(listOf())

    LazyColumn {
        items(posts.value) { post ->
            Text(text = post.title)
            Text(text = post.body)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}