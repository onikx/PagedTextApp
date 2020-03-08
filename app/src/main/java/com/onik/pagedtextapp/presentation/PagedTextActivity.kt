package com.onik.pagedtextapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onik.pagedtextapp.R
import com.onik.pagedtextapp.presentation.di.DaggerPagedTextComponent
import com.onik.pagedtextapp.presentation.di.PagedTextComponent
import com.onik.pagedtextapp.presentation.di.PagedTextModule
import kotlinx.android.synthetic.main.activity_pagedtext.*
import javax.inject.Inject

class PagedTextActivity : AppCompatActivity(), PaginatedTextView {

    lateinit var component: PagedTextComponent
    @Inject
    lateinit var presenter: PagedTextPresenter

    private var pageIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setupComponent()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagedtext)

        presenter.onViewCreated(this)

        buttonLast.setOnClickListener {
            if (pageIndex > 0) {
                textViewContent.next(--pageIndex)
                updatePaging()
            }
        }

        buttonNext.setOnClickListener {
            if (pageIndex < textViewContent.size() - 1) {
                textViewContent.next(++pageIndex)
                updatePaging()
            }
        }

        textViewContent.post {
            updatePaging()
        }
    }

    override fun setText(text: String?) {
        textViewContent?.text = text
    }

    fun setupComponent() {
        component = DaggerPagedTextComponent.builder()
            .pagedTextModule(
                PagedTextModule(this)
            )
            .build()
        component.inject(this)
    }

    private fun updatePaging() {
        textViewPaging.text =
            getString(
                R.string.paging,
                (pageIndex + 1).toString(),
                textViewContent.size().toString()
            )
    }
}
