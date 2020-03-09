package com.onik.pagedtextapp.util

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class FileReaderImpl @Inject constructor(
    private val context: Context
) : FileReader {
    
    override fun read(filename: String): String? {
        var reader: BufferedReader? = null
        var allText = ""
        try {
            val inputStream: InputStream = context.assets.open("text.txt")
            reader = BufferedReader(
                    InputStreamReader(context.assets.open("text.txt"), "UTF-8")
            )
            allText = inputStream.bufferedReader().use(BufferedReader::readText)
        } catch (e: IOException) {
            // todo handle error on reading
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                    // todo handle error on closing
                }
            }
        }
        return allText
    }
}