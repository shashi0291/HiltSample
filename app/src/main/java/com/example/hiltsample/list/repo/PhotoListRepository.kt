package com.example.hiltsample.list.repo

import com.example.hiltsample.list.model.Photo
import io.reactivex.Observable

interface PhotoListRepository {
    fun init()
    fun getPhotoListFromCache(): Observable<List<Photo>>
    fun getFromCacheOrFetch(): Observable<List<Photo>>
}