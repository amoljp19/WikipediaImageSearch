package com.softaai.wikipediaimagesearch.data.network

import com.softaai.wikipediaimagesearch.model.ImageSearchApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageSearchApiService {

    @GET("/w/api.php")
    suspend fun getImageSearchResponse(
        @Query("action") action:String = "query",
        @Query("generator") generator:String = "prefixsearch",
        @Query("gpssearch") term: String = "kotlin",
        @Query("prop") prop:String = "pageimages",
        @Query("piprop") piprop:String = "thumbnail",
        @Query("pithumbsize") pithumbsize:String = "200",
        @Query("pilimit") pilimit: String = "50",
        @Query("format") format:String = "json"
    ): Response<ImageSearchApiResponse>

    companion object {
        const val BASE_URL: String = "https://en.wikipedia.org"
    }
}