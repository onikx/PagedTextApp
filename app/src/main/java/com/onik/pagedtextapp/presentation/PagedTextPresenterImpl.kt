package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import com.onik.pagedtextapp.entity.Data
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val getTextUseCase: GetTextUseCase
) : PagedTextPresenter {

    companion object {
        private const val FILE_NAME = "text.txt"
    }

    override fun onViewCreated() =
        when (val data = getTextUseCase.execute(FILE_NAME)) {
            is Data.Value -> view.setText(data.value)
            is Data.Error -> view.setText(data.error.toString())
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