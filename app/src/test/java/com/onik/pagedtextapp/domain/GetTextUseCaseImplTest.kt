package com.onik.pagedtextapp.domain

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.onik.pagedtextapp.data.repo.TextRepo
import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import com.onik.pagedtextapp.domain.usecase.GetTextUseCaseImpl
import org.junit.Before
import org.junit.Test

class GetTextUseCaseImplTest {
    private lateinit var mockRepo: TextRepo
    private lateinit var useCase: GetTextUseCase

    @Before
    fun setUp() {
        mockRepo = mock { }

        useCase = GetTextUseCaseImpl(repo = mockRepo)
    }

    @Test
    fun `on execute(fileName) repo should get(fileName)`() {
        val mockFileName = "File name"

        useCase.execute(mockFileName)

        verify(mockRepo).get(mockFileName)
    }
}