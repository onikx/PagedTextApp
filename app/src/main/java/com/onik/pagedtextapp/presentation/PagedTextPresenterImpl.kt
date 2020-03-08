package com.onik.pagedtextapp.presentation

import android.content.Context
import com.onik.pagedtextapp.data.FileReader
import javax.inject.Inject

class PagedTextPresenterImpl @Inject constructor(
    private val view: PaginatedTextView,
    private val textProvider: FileReader) : PagedTextPresenter {

    override fun onViewCreated(context: Context) {
        val text = textProvider.read(context, "")
        view.setText(text)
    }
}