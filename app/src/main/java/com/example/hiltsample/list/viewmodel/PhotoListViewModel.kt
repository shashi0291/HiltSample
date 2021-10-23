package com.example.hiltsample.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltsample.list.model.Photo
import com.example.hiltsample.list.repo.PhotoListRepository
import com.example.hiltsample.list.ui.UiData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val repository: PhotoListRepository
) : ViewModel() {

    private val _photoList = MutableLiveData<List<UiData.PhotoUiData>>()
    val photoList: LiveData<List<UiData.PhotoUiData>> = _photoList

    private val disposable = CompositeDisposable()

    init {
        fetchPhotoList()
    }

    private fun fetchPhotoList() {
        disposable.add(
            repository.getFromCacheOrFetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ photoList ->
                    // main thread
                    photoList.mapNotNull { it.toViewData() }
                }, {
                    // error case
                    _photoList.value = null
                })
        )
    }

    fun Photo.toViewData() = when (this) {
        is Photo -> UiData.PhotoUiData(title)
        else -> null
    }
}