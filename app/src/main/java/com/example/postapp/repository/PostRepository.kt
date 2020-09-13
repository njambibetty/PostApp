package com.example.postapp.repository

import com.example.postapp.Models.Post
import com.example.postapp.api.ApiClient
import com.example.postapp.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO){
        val apiInterface=ApiClient.buildServices(ApiInterface::class.java)
        val response=apiInterface.getPosts()
        return@withContext response
    }
}