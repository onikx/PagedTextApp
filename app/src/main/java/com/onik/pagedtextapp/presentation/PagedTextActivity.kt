package com.onik.pagedtextapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onik.pagedtextapp.App
import com.onik.pagedtextapp.R
import com.onik.pagedtextapp.presentation.data.ViewState
import kotlinx.android.synthetic.main.activity_pagedtext.*
import javax.inject.Inject

class PagedTextActivity : AppCompatActivity(), PaginatedTextView {

    private var pageIndex: Int = 0
    @Inject
    lateinit var presenter: PagedTextPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        buildComponent()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagedtext)

        presenter.onViewCreated()

        buttonLast.setOnClickListener {
            presenter.onLastClicked()
        }

        buttonNext.setOnClickListener {
            presenter.onNextClicked()
        }

        textViewContent.post {
            updatePageNumber()
        }
    }

    private fun buildComponent() {
        (application as App)
            .uiComponentBuilder
            .pagedTextComponentBuilder
            .build(this)
            .inject(this)
    }

    override fun getSize(): Int = textViewContent?.size() ?: 0

    override fun getPageIndex(): Int = pageIndex

    override fun showLast() {
        textViewContent.next(--pageIndex)
    }

    override fun showNext() {
        textViewContent.next(++pageIndex)
    }

    override fun updatePageNumber() {
        textViewPaging.text =
            getString(
                R.string.paging,
                (pageIndex + 1).toString(),
                textViewContent.size().toString()
            )
    }

    override fun updateState(state: ViewState) = when (state) {
        is ViewState.Data -> textViewContent.text = state.data
        is ViewState.Error-> textViewContent.text = state.message
    }
}
