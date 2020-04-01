package com.onik.pagedtextapp.data.repo

import com.onik.pagedtextapp.entity.Data

interface TextRepo {
    fun get(): Data
}