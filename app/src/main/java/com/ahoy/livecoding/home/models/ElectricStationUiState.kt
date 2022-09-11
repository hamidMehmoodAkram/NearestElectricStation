package com.ahoy.livecoding.home.models


sealed class UIState<out T> {
    data class Success<T>(val data: T) : UIState<T>()
    object Loading : UIState<Nothing>()
    data class Error(val message:String) : UIState<Nothing>()
}