package com.onik.pagedtextapp.data.mapper

import com.onik.pagedtextapp.entity.Data

interface DataMapper {
    fun map(text: String): Data
    fun map(error: Throwable): Data
}