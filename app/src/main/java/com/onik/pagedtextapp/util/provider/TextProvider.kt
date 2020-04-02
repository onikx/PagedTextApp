package com.onik.pagedtextapp.util.provider

import java.io.IOException

interface TextProvider {

    fun get(fileName: String,
            onData: (String) -> Unit,
            onError: (IOException) -> Unit
    )
}