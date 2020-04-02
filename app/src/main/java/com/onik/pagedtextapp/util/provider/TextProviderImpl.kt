package com.onik.pagedtextapp.util.provider

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import javax.inject.Inject

class TextProviderImpl @Inject constructor(
    private val context: Context
) : TextProvider {

    override fun get(fileName: String,
                     onData: (String) -> Unit,
                     onError: (IOException) -> Unit
    ) {
        try {
            onData(
                context
                    .assets
                    .open(fileName)
                    .bufferedReader()
                    .use(BufferedReader::readText)
            )
        } catch (e: IOException) {
            onError(e)
        }
    }
}