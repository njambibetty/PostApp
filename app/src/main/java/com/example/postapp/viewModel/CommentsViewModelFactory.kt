package com.example.postapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.repository.PostRepository
import java.lang.IllegalArgumentException

class CommentsViewModelFactory (val commentsRepository: CommentRepository ): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CommentsViewModel::class.java)){
            return CommentsViewModel(commentsRepository) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}