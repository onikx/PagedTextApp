package com.onik.pagedtextapp.util.provider

interface TextProvider {

    fun get(fileName: String,
            onData: (String) -> Unit,
            onError: (Throwable) -> Unit
    )
}