package com.onik.pagedtextapp.presentation

interface PaginatedTextView {
    fun getSize(): Int
    fun getPageIndex(): Int
    fun setText(text: String?)
    fun showLast()
    fun showNext()
    fun updatePageNumber()
}