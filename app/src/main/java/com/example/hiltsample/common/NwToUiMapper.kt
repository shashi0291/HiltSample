package com.example.hiltsample.common

interface NwToUiMapper<NwModel, UiModel> {
    fun map(model: NwModel): UiModel
}