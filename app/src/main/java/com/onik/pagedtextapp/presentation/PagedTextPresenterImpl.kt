package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.util.TextProvider
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val textProvider: TextProvider
) : PagedTextPresenter {

    override fun onViewCreated() {
        val text = textProvider.get("")
        view.setText(text)
    }
}