package com.example.api_with_mvvm.service

import com.example.api_with_mvvm.model.DataList
import com.example.api_with_mvvm.model.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface APiService {

    @GET("posts") //No arguments
    fun getList() : Call<DataList>
    //URL :- https://jsonplaceholder.typicode.com/posts

    @GET("posts/{id}/comments") // Pass argument with @Path annotation
    fun getCommentList(@Path("id") postID:Int) : Call<UserData>
    //URL :- https://jsonplaceholder.typicode.com/posts/3/comments

    @GET("comments") // Pass argument with @Query annotation
    fun getCommentListQuery(@Query("postId") postID:Int) : Call<UserData>
    //URL :-  https://jsonplaceholder.typicode.com/comments?postId=3

    @GET("comments") // Pass argument with multiple @Query annotation
    fun getCommentListMultipleQuery(
        @Query("postId") postID:Int,
        @Query("_sort") shortBy:String,
        @Query("_order") orderBy:String,
    ) : Call<UserData>
    //URL :-  https://jsonplaceholder.typicode.com/comments?postId=3&_sort=id&_order=desc

    @GET("comments") // Pass argument with @QueryMap annotation
    fun getCommentListQueryHashMap(
        @QueryMap map : HashMap<String,String>
    ) : Call<UserData>
    //URL :-  https://jsonplaceholder.typicode.com/comments?_order=desc&postId=4&_sort=id
}