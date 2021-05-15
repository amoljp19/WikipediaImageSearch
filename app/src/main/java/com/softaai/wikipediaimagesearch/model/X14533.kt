package com.softaai.wikipediaimagesearch.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X14533(
    @Json(name = "index")
    val index: Int,
    @Json(name = "ns")
    val ns: Int,
    @Json(name = "pageid")
    val pageid: Int,
    @Json(name = "thumbnail")
    val thumbnail: ThumbnailX,
    @Json(name = "title")
    val title: String
)