package com.softaai.wikipediaimagesearch.di.module

import com.softaai.wikipediaimagesearch.data.network.ImageSearchApiService
import com.softaai.wikipediaimagesearch.data.network.RequestInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ImageSearchApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().addInterceptor(RequestInterceptor()).build();


    @Singleton
    @Provides
    fun provideRetrofitService(okHttpClient: OkHttpClient): ImageSearchApiService = Retrofit.Builder()
        .baseUrl(ImageSearchApiService.BASE_URL)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .client(okHttpClient)
        .build()
        .create(ImageSearchApiService::class.java)

}