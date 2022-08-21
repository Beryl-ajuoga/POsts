package dev.beryl.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts():Call<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id")postid:Int):Call<Post>
    abstract fun getComments(): Any

}