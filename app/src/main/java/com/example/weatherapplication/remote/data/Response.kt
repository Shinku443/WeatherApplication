package com.example.weatherapplication.remote.data

sealed class Response<T>(val data: T? = null, val msg: String? = null) {
    class Success<T>(data: T) : Response<T>(data)
    class Loading<T>(data: T? = null) : Response<T>(data)
    class Error<T>(data: T? = null, msg: String) : Response<T>(data, msg)
}