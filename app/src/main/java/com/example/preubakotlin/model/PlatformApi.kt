package com.example.preubakotlin.model

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface PlatformApi{

    @GET("platforms")
    suspend fun getPlatforms(@Query("api_key") apiKey:String): Response<List<Platform>>

}