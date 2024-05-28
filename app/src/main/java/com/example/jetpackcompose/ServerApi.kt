package com.example.jetpackcompose

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ServerApi {
    companion object {
        fun create(): ServerApi {
            return Retrofit.Builder()
                .baseUrl("https://github.com/Fargo02/JetpackCompose/blob/master/app/src/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ServerApi::class.java)
        }

    }
    @GET("/java/com/example/jetpackcompose/data/location.json")
    fun getCatalog(): Call<CategoryResponse>
}

data class CategoryResponse (
    val items: List<CategoryItem>
)
