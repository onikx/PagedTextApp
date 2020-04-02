package com.onik.pagedtextapp.data.repo

import com.onik.pagedtextapp.entity.Data
import com.onik.pagedtextapp.util.provider.TextProvider
import javax.inject.Inject

class TextRepoImpl @Inject constructor(
    private val textProvider: TextProvider
) : TextRepo {

    override fun get(fileName: String): Data {
        var data: Data = Data.Value("")

        textProvider.get(
            fileName = fileName,
            onData = { data = Data.Value(it) },
            onError = { data = Data.Error(it) }
        )

        return data
    }
}