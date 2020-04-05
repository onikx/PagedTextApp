package com.onik.pagedtextapp.presentation.mapper

import com.onik.pagedtextapp.entity.Data
import com.onik.pagedtextapp.presentation.data.ViewState

interface PagedTextMapper {
    fun map(data: Data): ViewState
}