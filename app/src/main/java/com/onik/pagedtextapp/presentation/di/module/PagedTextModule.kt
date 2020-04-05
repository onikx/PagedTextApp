package com.onik.pagedtextapp.presentation.di.module

import com.onik.pagedtextapp.presentation.PagedTextPresenter
import com.onik.pagedtextapp.presentation.PagedTextPresenterImpl
import com.onik.pagedtextapp.presentation.PaginatedTextView
import com.onik.pagedtextapp.presentation.mapper.PagedTextMapper
import com.onik.pagedtextapp.presentation.mapper.PagedTextMapperImpl
import dagger.Module
import dagger.Provides

@Module
class PagedTextModule(
    private val view: PaginatedTextView
) {

    @Provides
    fun provideView(): PaginatedTextView = this.view

    @Provides
    fun provideMapper(mapper: PagedTextMapperImpl): PagedTextMapper = mapper

    @Provides
    fun providePresenter(presenter: PagedTextPresenterImpl): PagedTextPresenter = presenter
}