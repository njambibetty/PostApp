package com.example.postapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object ApiClient {
    var  client:OkHttpClient=OkHttpClient.Builder().build()
    var retrofit:Retrofit= Retrofit.Builder()
        .baseUrl("http://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> buildServices(service:Class<T>):T{
        return retrofit.create(service)
    }

}