package com.example.postapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.repository.PostRepository
import java.lang.IllegalArgumentException

class PostsViewModelFactory (val postsRepository: PostRepository ): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostsViewModel::class.java)){
            return PostsViewModel(postsRepository) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}