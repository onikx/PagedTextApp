package com.onik.pagedtextapp.presentation.di.module

import com.nhaarman.mockito_kotlin.mock
import com.onik.pagedtextapp.presentation.PagedTextPresenter
import dagger.Module
import dagger.Provides

@Module
class TestPagedTextModule {

    @Provides
    fun providePresenter(): PagedTextPresenter = mock()
}