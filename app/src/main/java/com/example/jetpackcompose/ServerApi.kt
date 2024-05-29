package com.example.jetpackcompose

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServerApi {
//    companion object {
//        fun create(): ServerApi {
//            return Retrofit.Builder()
//                .baseUrl("https://raw.githubusercontent.com/Fargo02/JetpackCompose/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ServerApi::class.java)
//        }
//    }
    @GET("/master/app/src/main/java/com/example/jetpackcompose/data/location.json")
    fun getCategory(): Call<CategoryResponse>
}

data class CategoryResponse (
    val items: List<CategoryItem>
)