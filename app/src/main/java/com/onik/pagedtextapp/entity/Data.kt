package com.onik.pagedtextapp.entity

sealed class Data {
    data class Value(val value: String): Data()
    data class Error(val error: Throwable): Data()
}