package com.example.preubakotlin.model

import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("project_count")
    val projectCount: String? = null,
    @SerializedName("homepage")
    val homepage: String? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("default_language")
    val defaultLanguage: String? = null
)