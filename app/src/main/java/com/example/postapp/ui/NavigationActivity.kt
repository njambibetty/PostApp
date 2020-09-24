package com.example.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        post.setOnClickListener {
            startActivity(Intent(baseContext,MainActivity::class.java))
        }
        comment.setOnClickListener {
            startActivity(Intent(baseContext,CommentsActivity::class.java))
        }
    }
}