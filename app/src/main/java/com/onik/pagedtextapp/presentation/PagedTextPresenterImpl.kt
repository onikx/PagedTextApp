package com.onik.pagedtextapp.presentation

import com.onik.pagedtextapp.util.FileReader
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val textProvider: FileReader
) : PagedTextPresenter {

    override fun onViewCreated() {
        val text = textProvider.read("")
        view.setText(text)
    }
}