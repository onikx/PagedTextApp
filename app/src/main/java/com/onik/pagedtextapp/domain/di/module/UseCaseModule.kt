package com.onik.pagedtextapp.domain.di.module

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import com.onik.pagedtextapp.domain.usecase.GetTextUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetTextUseCase(useCase: GetTextUseCaseImpl): GetTextUseCase = useCase
}