package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import com.onik.pagedtextapp.presentation.mapper.PagedTextMapper
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val mapper: PagedTextMapper,
    private val useCase: GetTextUseCase
) : PagedTextPresenter {

    companion object {
        private const val FILE_NAME = "text.txt"
    }

    override fun onViewCreated() {
        val data = useCase.execute(FILE_NAME)
        view.updateState(mapper.map(data))
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