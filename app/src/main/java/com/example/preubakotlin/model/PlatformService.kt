package com.example.preubakotlin.model

import com.example.preubakotlin.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PlatformService {
    private val client = OkHttpClient.Builder().build()

    private fun getRetrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getDogApi(): PlatformApi{
        return getRetrofitBuilder().create(PlatformApi::class.java)
    }
}