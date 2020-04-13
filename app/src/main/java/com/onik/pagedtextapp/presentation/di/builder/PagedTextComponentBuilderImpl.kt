package com.onik.pagedtextapp.presentation.di.builder

import com.onik.pagedtextapp.App
import com.onik.pagedtextapp.presentation.PaginatedTextView
import com.onik.pagedtextapp.presentation.di.component.DaggerPagedTextComponent
import com.onik.pagedtextapp.presentation.di.component.PagedTextComponent
import com.onik.pagedtextapp.presentation.di.module.PagedTextModule

class PagedTextComponentBuilderImpl constructor(private val app: App) : PagedTextComponentBuilder {

    override fun build(view: PaginatedTextView): PagedTextComponent =
        DaggerPagedTextComponent.builder()
            .domainComponent(app.domainComponent)
            .pagedTextModule(PagedTextModule(view))
            .build()
}