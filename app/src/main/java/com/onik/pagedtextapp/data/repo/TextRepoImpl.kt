package com.onik.pagedtextapp.data.repo

import com.onik.pagedtextapp.util.provider.TextProvider
import javax.inject.Inject

class TextRepoImpl @Inject constructor(
    private val textProvider: TextProvider
) : TextRepo {

    override fun get(): String = textProvider.get("") ?: ""
}