package com.onik.pagedtextapp.presentation.di.builder

import com.onik.pagedtextapp.presentation.PaginatedTextView
import com.onik.pagedtextapp.presentation.di.component.PagedTextComponent

interface PagedTextComponentBuilder {
    fun build(view: PaginatedTextView): PagedTextComponent
}