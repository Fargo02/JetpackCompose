package com.example.jetpackcompose

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
//    private val serverApi: ServerApi by lazy {
//        ServerApi.create()
//    }
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Fargo02/JetpackCompose/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val serverApi = retrofit.create(ServerApi::class.java)
    private var categories = ArrayList<CategoryItem>()
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        serverApi.getCategory().enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
                    val responseBody = response.body()?.items
                    if (response.code() == 200 && responseBody != null) {
                        categories.addAll(responseBody)
                        Log.d("cool", "onResponse: error call=$call body=$responseBody")

                    } else {
                        Log.d("onResponse", "onResponse: error ${response.code()} call=$call body=$responseBody")
                    }
                }
                override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                    Log.d("onFailure", "onFailure: error call=$call $t")
                }
            })
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {
                Toolbar()
                Category(categories)
            }
        }
    }
    private fun requestToServer() {

    }
}
