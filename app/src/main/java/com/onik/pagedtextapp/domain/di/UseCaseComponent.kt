package com.onik.pagedtextapp.domain.di

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase

interface UseCaseComponent {
    val getTextUseCase: GetTextUseCase
}