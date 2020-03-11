package com.onik.pagedtextapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onik.pagedtextapp.App
import com.onik.pagedtextapp.R
import com.onik.pagedtextapp.presentation.di.DaggerPagedTextComponent
import com.onik.pagedtextapp.presentation.di.PagedTextComponent
import com.onik.pagedtextapp.presentation.di.PagedTextModule
import kotlinx.android.synthetic.main.activity_pagedtext.*
import javax.inject.Inject

class PagedTextActivity : AppCompatActivity(), PaginatedTextView {

    private var pageIndex: Int = 0
    private lateinit var component: PagedTextComponent
    @Inject
    lateinit var presenter: PagedTextPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setupComponent()

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

    override fun getSize(): Int = textViewContent?.size() ?: 0

    override fun getPageIndex(): Int = pageIndex

    override fun setText(text: String?) {
        textViewContent?.text = text
    }

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

    fun setupComponent() {
        component = DaggerPagedTextComponent.builder()
            .utilComponent((application as App).utilComponent)
            .pagedTextModule(
                PagedTextModule(this)
            )
            .build()
        component.inject(this)
    }
}
