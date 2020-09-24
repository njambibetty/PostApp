package com.example.postapp

import android.content.Context

class postapp {
    override fun onCreate(){
        super.onCreate()
        PostsApp.app
    }
    companion object{
        lateinit var appContext: Context

    }
}