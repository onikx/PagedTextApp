package com.onik.pagedtextapp

import android.content.Context

interface FileReader {
    fun read(context: Context, filename: String): String?
}