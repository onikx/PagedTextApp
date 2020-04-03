package com.onik.pagedtextapp.domain.di.component

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase

interface UseCaseComponent {
    val getTextUseCase: GetTextUseCase
}