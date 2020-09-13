package com.example.postapp.UI

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.repository.PostRepository
import com.example.postapp.ui.PostsAdapter
import com.example.postapp.viewModel.PostsViewModel
import com.example.postapp.viewModel.PostsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postsRepository= PostRepository()
        postsViewModelFactory= PostsViewModelFactory(postsRepository)
        postsViewModel=
            ViewModelProvider(this, postsViewModelFactory).get(PostsViewModel::class.java)

        postsViewModel.getPosts()

        postsViewModel.postsLiveData.observe(this, Observer { postsList->
            recycler_post.apply{
                layoutManager= LinearLayoutManager(this@MainActivity)
                hasFixedSize()
                adapter= PostsAdapter(postsList)
            }
            Toast.makeText(baseContext,"${postsList.size} posts fetched",Toast.LENGTH_LONG).show()
        })
        postsViewModel.postsFailedLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
}
