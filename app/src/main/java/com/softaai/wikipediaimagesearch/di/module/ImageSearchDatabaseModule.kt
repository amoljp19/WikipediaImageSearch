package com.softaai.wikipediaimagesearch.di.module

import android.app.Application
import com.softaai.wikipediaimagesearch.data.persistence.WikiImageSearchAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ImageSearchDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = WikiImageSearchAppDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providePagesDao(database: WikiImageSearchAppDatabase) = database.getPagesDao()
}