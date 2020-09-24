package com.example.postapp.repository

import com.example.postapp.Models.Post
import com.example.postapp.api.ApiClient
import com.example.postapp.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response

class CommentRepository {
    suspend fun getComments(): Response<List<Comment>> = withContext(Dispatchers.IO){
        val apiInterface=ApiClient.buildServices(ApiInterface::class.java)
        val response=apiInterface.getComments()
        return@withContext response
        if (response.isSuccessful){
            val comments = response.body() as List<Comment>
            savePosts(comments)
        }
    }
    suspend fun saveComments(commentslist:List<Comments>) = withContext(Dispatcher.IO){
    val database = CommentAppDatabase.getDbInstance()
    commentList.forEach { comment ->
        database.postDao().insertPost(post)
    }
    }
    fun
}