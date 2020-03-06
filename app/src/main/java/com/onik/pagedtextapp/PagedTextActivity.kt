package com.onik.pagedtextapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onik.pagedtextapp.di.DaggerPagedTextComponent
import com.onik.pagedtextapp.di.PagedTextComponent
import com.onik.pagedtextapp.di.PagedTextModule
import kotlinx.android.synthetic.main.activity_pagedtext.*

class PagedTextActivity : AppCompatActivity() {

    lateinit var component: PagedTextComponent

    private var pageIndex: Int = 0
    private val fileReader: FileReader = FileReaderImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        setupComponent()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagedtext)

        val text = fileReader.read(this, "")
        textViewContent.text = text

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

    fun setupComponent() {
        component = DaggerPagedTextComponent.builder()
            .pagedTextModule(
                PagedTextModule()
            )
            .build()
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
