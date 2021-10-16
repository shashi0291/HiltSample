package com.example.hiltsample.list.service

import com.example.hiltsample.list.model.Photo
import com.example.hiltsample.list.model.PhotosRes
import io.reactivex.Observable
import retrofit2.http.GET

interface PhotosService {

    @GET("/photos")
    fun fetchPhotos(): Observable<List<Photo>>
}