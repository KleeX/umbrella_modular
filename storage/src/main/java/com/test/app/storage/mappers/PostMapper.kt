package com.test.app.storage.mappers

import com.test.app.data.Post
import com.test.app.storage.db.PostEntity

fun PostEntity.toPost(): Post = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)

fun Post.toPostEntity(): PostEntity = PostEntity(
    id = id,
    userId = userId,
    title = title,
    body = body
)