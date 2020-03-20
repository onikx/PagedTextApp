package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val getTextUseCase: GetTextUseCase
) : PagedTextPresenter {

    override fun onViewCreated() {
        view.setText(
            getTextUseCase.execute()
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