package com.onik.pagedtextapp.presentation.di.builder

import com.onik.pagedtextapp.presentation.PaginatedTextView
import com.onik.pagedtextapp.presentation.di.component.DaggerTestPagedTextComponent
import com.onik.pagedtextapp.presentation.di.component.PagedTextComponent
import com.onik.pagedtextapp.presentation.di.module.TestPagedTextModule

class TestPagedTextComponentBuilderImpl : PagedTextComponentBuilder {

    override fun build(view: PaginatedTextView): PagedTextComponent =
        DaggerTestPagedTextComponent.builder()
            .testPagedTextModule(TestPagedTextModule())
            .build()
}