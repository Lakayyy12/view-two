package com.application.putangina.utilss

sealed class Jordi<out T> {
    data class Success<out T>(val data: T): Jordi<T>()
    data class Error(val exception: Throwable): Jordi<Nothing>()
}