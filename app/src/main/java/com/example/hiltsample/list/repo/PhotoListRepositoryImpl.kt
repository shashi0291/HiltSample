package com.example.hiltsample.list.repo

import android.annotation.SuppressLint
import com.example.hiltsample.list.model.Photo
import com.example.hiltsample.list.model.PhotosRes
import com.example.hiltsample.list.service.PhotosService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class PhotoListRepositoryImpl @Inject constructor(
    private val photosService: PhotosService
) : PhotoListRepository {

    private val photoListSubject = BehaviorSubject.create<List<Photo>>()

    @SuppressLint("CheckResult")
    override fun init() {
        photosService.fetchPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                photoListSubject.onNext(it)
            }, {
                photoListSubject.onError(it)
            })
    }


    override fun getPhotoListFromCache(): Observable<List<Photo>> {
        return photoListSubject.toSerialized().subscribeOn(Schedulers.io())
    }

    override fun getFromCacheOrFetch(): Observable<List<Photo>> {
        if (!photoListSubject.hasValue()) {
            init()
        }
        return getPhotoListFromCache()
    }
}