package com.example.myapp.data

import com.example.myapp.Constants
import com.example.myapp.data.api.Retrofit_interface
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit_client{
    val apiService:Retrofit_interface
        get() = instace.create(Retrofit_interface::class.java)
    private val instace:Retrofit
        private get(){
            val gson=GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}
