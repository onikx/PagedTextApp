package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import com.onik.pagedtextapp.entity.Data
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val getTextUseCase: GetTextUseCase
) : PagedTextPresenter {

    override fun onViewCreated() {
        when (val data = getTextUseCase.execute()) {
            is Data.Value -> view.setText(data.value)
            is Data.Error -> view.setText(data.error.localizedMessage)
        }
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