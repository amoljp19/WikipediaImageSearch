package com.softaai.wikipediaimagesearch.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageSearchApiResponse(
    @Json(name = "batchcomplete")
    val batchcomplete: String,
    @Json(name = "continue")
    val continueX: Continue,
    @Json(name = "query")
    val query: Query
){
    companion object {
        const val TABLE_NAME = "news_articles"
    }
}