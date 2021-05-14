package com.example.preubakotlin1.model

import com.google.gson.annotations.SerializedName

data class Dog(
    @SerializedName("message")
    val image: String? = null,
    @SerializedName("status")
    val status: String? = null
)