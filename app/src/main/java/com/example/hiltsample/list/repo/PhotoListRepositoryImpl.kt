package com.example.hiltsample.list.repo

import com.example.hiltsample.list.model.Photo
import com.example.hiltsample.list.model.PhotosRes
import com.example.hiltsample.list.service.PhotosService
import io.reactivex.Observable
import javax.inject.Inject

class PhotoListRepositoryImpl @Inject constructor(
    private val photosService: PhotosService
) : PhotoListRepository {

    override fun fetchPhotoList(): Observable<List<Photo>> {
        return photosService.fetchPhotos()
    }
}