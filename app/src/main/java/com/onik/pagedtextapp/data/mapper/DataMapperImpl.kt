package com.onik.pagedtextapp.data.mapper

import com.onik.pagedtextapp.entity.Data
import javax.inject.Inject

class DataMapperImpl @Inject constructor() : DataMapper {

    override fun map(text: String): Data = Data.Value(text)

    override fun map(error: Throwable): Data = Data.Error(error)
}