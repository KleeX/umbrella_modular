package com.test.app.storage.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostEntity>)

    @Query("DELETE FROM posts WHERE id NOT IN (:postIdsToKeep)")
    suspend fun deleteOutdatedPosts(postIdsToKeep: List<Int>)

    @Query("SELECT * FROM posts")
    fun getAllPosts(): Flow<List<PostEntity>>

    @Query("SELECT * FROM posts WHERE id = :postId")
    fun getPostById(postId: Int): Flow<PostEntity?>


    @Transaction
    suspend fun updatePosts(posts: List<PostEntity>) {
        insertPosts(posts)
        deleteOutdatedPosts(posts.map { it.id })
    }
}