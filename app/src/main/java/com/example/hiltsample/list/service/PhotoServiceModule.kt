package com.example.hiltsample.list.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class PhotoServiceModule {

    @Provides
    fun providePhotoServiceInstance(retrofit: Retrofit): PhotosService {
        return retrofit.create(PhotosService::class.java)
    }
}