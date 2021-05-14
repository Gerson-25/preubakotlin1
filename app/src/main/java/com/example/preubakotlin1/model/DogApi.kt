package com.example.preubakotlin1.model

import com.example.preubakotlin1.model.Dog
import com.example.preubakotlin1.util.BASE_URL
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface DogApi{
    @GET("image/random")
    suspend fun getDog(): Response<Dog>

}