package com.softaai.wikipediaimagesearch.data.repository

import com.softaai.wikipediaimagesearch.data.network.ImageSearchApiService
import com.softaai.wikipediaimagesearch.data.network.Resource
import com.softaai.wikipediaimagesearch.data.persistence.PagesDao
import com.softaai.wikipediaimagesearch.model.ImageSearchApiResponse
import com.softaai.wikipediaimagesearch.model.Pages
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface ImageSearchRepository {
    fun getPages(): Flow<Resource<Pages>>
}

class DefaultImageSearchRepository @Inject constructor(
        private val pagesDao: PagesDao,
        private val imageSearchApiService: ImageSearchApiService
) : ImageSearchRepository {

    override fun getPages(): Flow<Resource<Pages>> {
        return object : NetworkBoundRepository<Pages, ImageSearchApiResponse>() {

            override suspend fun saveRemoteData(response: ImageSearchApiResponse) = pagesDao.addPages(response.query.pages)

            override fun fetchFromLocal(): Flow<Pages> = pagesDao.getAllPages()

            override suspend fun fetchFromRemote(): Response<ImageSearchApiResponse> = imageSearchApiService.getImageSearchResponse()

        }.asFlow()
    }

}