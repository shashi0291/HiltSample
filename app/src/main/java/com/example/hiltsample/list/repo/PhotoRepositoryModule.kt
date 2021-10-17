package com.example.hiltsample.list.repo

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import io.reactivex.Single
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PhotoRepositoryModule {

    @Binds
    @Singleton // made singleton because the repo has to be shared with two view models, and that's why it needs to be installed in SingletonComponent
    abstract fun bindPhotoRepositoryInstance(impl: PhotoListRepositoryImpl): PhotoListRepository
}