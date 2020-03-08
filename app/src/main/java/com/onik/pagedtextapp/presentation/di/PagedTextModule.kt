package com.onik.pagedtextapp.presentation.di

import com.onik.pagedtextapp.data.FileReader
import com.onik.pagedtextapp.data.FileReaderImpl
import com.onik.pagedtextapp.presentation.PagedTextPresenter
import com.onik.pagedtextapp.presentation.PagedTextPresenterImpl
import com.onik.pagedtextapp.presentation.PaginatedTextView
import dagger.Module
import dagger.Provides

@Module
class PagedTextModule(
    private val view: PaginatedTextView
) {

    @Provides
    fun provideView(): PaginatedTextView = this.view

    @Provides
    fun providePresenter(presenter: PagedTextPresenterImpl): PagedTextPresenter = presenter

    @Provides
    fun provideTextProvider(provider: FileReaderImpl): FileReader = provider
}