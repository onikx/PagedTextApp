package com.onik.pagedtextapp.domain.usecase

import com.onik.pagedtextapp.entity.Data

interface GetTextUseCase {
    fun execute(): Data
}