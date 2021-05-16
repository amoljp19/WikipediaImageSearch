package com.softaai.wikipediaimagesearch.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbnailXXXXXX(
    @Json(name = "height")
    val height: Int,
    @Json(name = "source")
    val source: String,
    @Json(name = "width")
    val width: Int
)