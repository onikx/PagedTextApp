package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.presentation.data.ViewState

interface PaginatedTextView {
    fun getSize(): Int
    fun getPageIndex(): Int
    fun showLast()
    fun showNext()
    fun updatePageNumber()
    fun updateState(state: ViewState)
}