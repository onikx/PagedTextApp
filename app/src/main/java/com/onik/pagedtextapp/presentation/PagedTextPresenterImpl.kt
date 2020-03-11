package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.util.TextProvider
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val textProvider: TextProvider
) : PagedTextPresenter {

    override fun onViewCreated() {
        view.setText(
            textProvider.get("")
        )
    }

    override fun onLastClicked() {
        if (view.getPageIndex() > 0) {
            view.showLast()
            view.updatePageNumber()
        }
    }

    override fun onNextClicked() {
        if (view.getPageIndex() < view.getSize() - 1) {
            view.showNext()
            view.updatePageNumber()
        }
    }
}