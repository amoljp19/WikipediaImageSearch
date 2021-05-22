package com.softaai.wikipediaimagesearch.di.module

import com.softaai.wikipediaimagesearch.data.repository.DefaultImageSearchRepository
import com.softaai.wikipediaimagesearch.data.repository.ImageSearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped


@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class ImageSearchRepositoryModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindImageSearchRepository(imageSearchRepository: DefaultImageSearchRepository): ImageSearchRepository

}