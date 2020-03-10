package com.onik.pagedtextapp.util

interface TextProvider {
    fun get(path: String): String?
}