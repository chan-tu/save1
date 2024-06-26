package com.example.myapp.data.api

import com.example.myapp.data.model.ImageModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Retrofit_interface {
    @GET("v2/search/image")
    fun image_search(
        @Header("Authorization")apiKey:String?,
        @Query("query")query: String?,
        @Query("sort")sort:String?,
        @Query("page")page:Int,
        @Query("size")size:Int
    ): Call<ImageModel?>?
}
