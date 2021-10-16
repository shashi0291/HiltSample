package com.example.hiltsample.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltsample.list.model.Photo
import com.example.hiltsample.list.repo.PhotoListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val repository: PhotoListRepository
) : ViewModel() {

    private val _photoList = MutableLiveData<List<Photo>>()
    val photoList: LiveData<List<Photo>> = _photoList

    private val disposable = CompositeDisposable()

    init {
        fetchPhotoList()
    }

    private fun fetchPhotoList() {
        disposable.add(
            repository.fetchPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // main thread
                    _photoList.value = it
                }, {
                    // error case
                    _photoList.value = null
                })
        )
    }
}