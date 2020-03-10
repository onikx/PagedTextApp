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

    override fun onLastClicked() {
        if (view.getPageIndex() > 0) {
            view.showLast()
        }
    }

    override fun onNextClicked() {
        if (view.getPageIndex() < view.getSize() - 1) {
            view.showNext()
        }
    }
}