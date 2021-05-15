package com.softaai.wikipediaimagesearch.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X407754(
    @Json(name = "index")
    val index: Int,
    @Json(name = "ns")
    val ns: Int,
    @Json(name = "pageid")
    val pageid: Int,
    @Json(name = "title")
    val title: String
)