package com.example.postapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.Models.Post
import com.example.postapp.repository.PostRepository
import kotlinx.coroutines.launch

class PostsViewModel (val postRepository: PostRepository):ViewModel() {
    val postsLiveData=MutableLiveData<List<Post>>()
    val postsFailedLiveData=MutableLiveData<String>()

    fun getPosts() {
        viewModelScope.launch {
            val response = postRepository.getPosts()
            if (!response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
    fun getDbPosts(){

    }


}