package com.example.hiltsample.list.repo

import com.example.hiltsample.list.model.Photo
import io.reactivex.Observable

interface PhotoListRepository {

    fun fetchPhotoList(): Observable<List<Photo>>
}