package com.onik.pagedtextapp.data

import android.content.Context

interface FileReader {
    fun read(context: Context, filename: String): String?
}