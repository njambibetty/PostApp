package com.example.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CommentsActivity : AppCompatActivity() {
    lateinit var commentsViewModel: CommentsViewModel
    lateinit var commentsViewModelFactory: CommentsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val commentsRepository= CommentsRepository()
        commentsViewModelFactory= CommentsViewModelFactory(commentsRepository)
        commentsViewModel=
            ViewModelProvider(this, commentsViewModelFactory).get(CommentsViewModel::class.java)

        commentsViewModel.getPosts()

        commentsViewModel.commentsLiveData.observe(this, Observer { commentsList->
            rvComments.apply{
                layoutManager= LinearLayoutManager(this@CommentsActivity)
                hasFixedSize()
                adapter=CommentsAdapter(commentsList)
            }
            Toast.makeText(baseContext,"${commentsList.size} comments fetched", Toast.LENGTH_LONG).show()
        })
        commentsViewModel.commentsFailedLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })

    }
}