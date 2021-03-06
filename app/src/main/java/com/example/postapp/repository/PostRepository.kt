package com.example.postapp.repository

import com.example.postapp.Models.Post
import com.example.postapp.api.ApiClient
import com.example.postapp.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response

class PostRepository {
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO){
        val apiInterface=ApiClient.buildServices(ApiInterface::class.java)
        val response=apiInterface.getPosts()
        return@withContext response
        if (response.isSuccessful){
            val posts = response.body() as List<Post>
            savePosts(posts)
        }
    }
    suspend fun savePosts(postslist:List<Posts>) = withContext(Dispatcher.IO){
    val database = PostAppDatabase.getDbInstance()
    postList.forEach { post ->
        database.postDao().insertPost(post)
    }
    }
    fun
}