package com.onik.pagedtextapp.util.provider

interface TextProvider {
    fun get(path: String): String?
}