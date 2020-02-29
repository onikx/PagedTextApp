package com.onik.pagedtextapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pagedtext.*

class PagedTextActivity : AppCompatActivity() {

    private var pageIndex: Int = 0
    private val fileReader: FileReader = FileReaderImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagedtext)

        val text = fileReader.read(this, "")
        textViewContent.text = text

        buttonLast.setOnClickListener {
            if (pageIndex > 0) {
                textViewContent.nextPage(--pageIndex)
                updatePaging()
            }
        }

        buttonNext.setOnClickListener {
            if (pageIndex < textViewContent.size() - 1) {
                textViewContent.nextPage(++pageIndex)
                updatePaging()
            }
        }

        textViewContent.post {
            updatePaging()
        }
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
