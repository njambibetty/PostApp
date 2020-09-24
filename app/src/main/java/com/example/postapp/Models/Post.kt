package com.example.postapp.Models

import android.content.Context
import java.security.AccessControlContext

data class Post (
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)
@Database(entities = arrayOf(Post::class), version = 1
    abstract class PostAppDatabase: RoomDatabase{
    abstract fun postDao():PostDao

    companion object{
        private var dbInstance: PostAppDatabase? = null

        fun getDbInstance(context: Context):PostAppDatabase{
            if (dbInstance==null){
                dbInstance=Room.databaseBuilder(context, PostAppDatabase:: class java, name "postapp-db").build()
            }
            return dbInstance as PostAppDatabase
        }
    }
}