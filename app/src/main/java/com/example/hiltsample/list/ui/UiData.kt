package com.example.hiltsample.list.ui

import androidx.annotation.LayoutRes
import com.example.hiltsample.R
import com.example.hiltsample.databinding.ListItemPhotoBinding

sealed class UiData(@LayoutRes val layoutId: Int) {
    data class PhotoUiData(val title: String): UiData(R.layout.list_item_photo)
}