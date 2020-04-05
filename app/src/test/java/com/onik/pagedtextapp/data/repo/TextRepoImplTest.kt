package com.onik.pagedtextapp.data.repo

import com.nhaarman.mockito_kotlin.anyOrNull
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.onik.pagedtextapp.data.mapper.DataMapper
import com.onik.pagedtextapp.util.provider.TextProvider
import org.junit.Before
import org.junit.Test

class TextRepoImplTest {
    private lateinit var mockMapper: DataMapper
    private lateinit var mockTextProvider: TextProvider
    private lateinit var repo: TextRepo

    @Before
    fun setUp() {
        mockMapper = mock { }
        mockTextProvider = mock { }

        repo = TextRepoImpl(
            mapper = mockMapper,
            textProvider = mockTextProvider
        )
    }

    @Test
    fun `on get(fileName) textProvider should get(_)`() {
        val mockFileName = "File name"

        repo.get(mockFileName)

        verify(mockTextProvider).get(
            fileName = eq(mockFileName),
            onData = anyOrNull(),
            onError = anyOrNull()
        )
    }
}