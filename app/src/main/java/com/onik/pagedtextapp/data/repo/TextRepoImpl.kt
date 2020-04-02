package com.onik.pagedtextapp.data.repo

import com.onik.pagedtextapp.data.mapper.DataMapper
import com.onik.pagedtextapp.entity.Data
import com.onik.pagedtextapp.util.provider.TextProvider
import javax.inject.Inject

class TextRepoImpl @Inject constructor(
    private val mapper: DataMapper,
    private val textProvider: TextProvider
) : TextRepo {

    override fun get(fileName: String): Data {
        var data: Data? = null

        textProvider.get(
            fileName = fileName,
            onData = { data = mapper.map(it) },
            onError = { data = mapper.map(it) }
        )

        return data ?: mapper.map(Throwable())
    }
}