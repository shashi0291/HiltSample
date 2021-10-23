package com.example.hiltsample.di

import android.app.Application
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ImageModule {

    @Provides
    fun providePicassoInstance(context: Application): Picasso {
        return Picasso.Builder(context)
            .build()
    }
}