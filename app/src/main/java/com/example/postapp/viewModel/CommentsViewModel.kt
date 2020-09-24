package com.example.postapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp.Models.Post
import com.example.postapp.repository.PostRepository
import kotlinx.coroutines.launch

class CommentsViewModel (val commentRepository: CommentsRepository):ViewModel() {
    val commentsLiveData=MutableLiveData<List<Comment>>()
    val commentsFailedLiveData=MutableLiveData<String>()

    fun getComments() {
        viewModelScope.launch {
            val response = commentsRepository.getComments()
            if (!response.isSuccessful) {
                commentsLiveData.commentsValue(response.body())
            } else {
                commentsFailedLiveData.commentValue(response.errorBody()?.string())
            }

        }
    }
    fun getDbComments(){

    }


}