package com.example.preubakotlin1.model

import com.example.preubakotlin1.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogService {
    private val client = OkHttpClient.Builder().build()

    private fun getRetrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getDogApi(): DogApi{
        return getRetrofitBuilder().create(DogApi::class.java)
    }
}