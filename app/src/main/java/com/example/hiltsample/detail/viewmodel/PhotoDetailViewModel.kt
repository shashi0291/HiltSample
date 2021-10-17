package com.example.hiltsample.detail.viewmodel

import androidx.lifecycle.ViewModel
import com.example.hiltsample.list.repo.PhotoListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val repository: PhotoListRepository
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun getPhotoById(id: Int) {
        compositeDisposable.add(
            repository.fetchPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                     println("Something")
                }, {
                    println("something")
                })
        )
    }
}