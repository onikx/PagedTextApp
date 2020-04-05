package com.onik.pagedtextapp.presentation.mapper

import com.onik.pagedtextapp.entity.Data
import com.onik.pagedtextapp.presentation.data.ViewState
import javax.inject.Inject

class PagedTextMapperImpl @Inject constructor() : PagedTextMapper {

    override fun map(data: Data): ViewState = when (data) {
        is Data.Value -> ViewState.Data(data.value)
        is Data.Error -> ViewState.Error(data.error.toString())
    }
}