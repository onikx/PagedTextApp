package com.onik.pagedtextapp.util.provider

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class TextProviderImpl @Inject constructor(
    private val context: Context
) : TextProvider {

    override fun get(path: String, onData: (String) -> Unit, onError: (IOException) -> Unit) {
        try {
            val inputStream: InputStream = context.assets.open("text.txt")
            val text = inputStream.bufferedReader().use(BufferedReader::readText)
            onData(text)
        } catch (e: IOException) {
            onError(e)
        }
    }
}