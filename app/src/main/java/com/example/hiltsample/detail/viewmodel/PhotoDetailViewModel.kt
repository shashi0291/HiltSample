package com.example.hiltsample.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hiltsample.list.model.Photo
import com.example.hiltsample.list.repo.PhotoListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val repository: PhotoListRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun getPhotoById(id: Int) {
        compositeDisposable.add(
            repository.getFromCacheOrFetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                     println("Something")
                }, {
                    println("something")
                })
        )
    }

    fun getPhotoById2(id: Int) {
        compositeDisposable.add(
            repository.getFromCacheOrFetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { photoList ->
                    photoList.filter { it.id == id }
                }
                .subscribe({
                     println("========= ${it[0].title}")
                }, {
                    println("========= ${it.message}")
                })
        )
    }
}