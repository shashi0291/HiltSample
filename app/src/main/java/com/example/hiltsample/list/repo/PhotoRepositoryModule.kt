package com.example.hiltsample.list.repo

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class PhotoRepositoryModule {

    @Binds
    @ViewModelScoped // so that hilt create only once instance of PhotoListRepository per viewmodel
    abstract fun bindPhotoRepositoryInstance(impl: PhotoListRepositoryImpl): PhotoListRepository
}