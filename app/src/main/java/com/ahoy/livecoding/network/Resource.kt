package com.ahoy.livecoding.network

sealed class Resource<T>{
    data class Data<T>(val data : T) : Resource<T>()
    data class Error(val errorMessage : String, val errorCode : Int) : Resource<Nothing>()
}