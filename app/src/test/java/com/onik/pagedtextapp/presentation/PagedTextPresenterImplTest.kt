package com.onik.pagedtextapp.presentation

import com.nhaarman.mockito_kotlin.*
import com.onik.pagedtextapp.domain.usecase.GetTextUseCase
import com.onik.pagedtextapp.entity.Data
import com.onik.pagedtextapp.presentation.data.ViewState
import com.onik.pagedtextapp.presentation.mapper.PagedTextMapper
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString

class PagedTextPresenterImplTest {
    private lateinit var mockView: PaginatedTextView
    private lateinit var mockMapper: PagedTextMapper
    private lateinit var mockUseCase: GetTextUseCase
    private lateinit var presenter: PagedTextPresenter

    @Before
    fun setUp() {
        mockView = mock { }
        mockMapper = mock { }
        mockUseCase = mock { }

        presenter = PagedTextPresenterImpl(
            view = mockView,
            mapper = mockMapper,
            useCase = mockUseCase
        )
    }

    @Test
    fun `onViewCreated() view should updateState(_) with the state that mapper returns`() {

        val mockData = Data.Value("value")
        val mockState = ViewState.Data("data")

        whenever(mockUseCase.execute(anyString())).thenReturn(mockData)
        whenever(mockMapper.map(any())).thenReturn(mockState)

        presenter.onViewCreated()

        verify(mockView).updateState(mockState)
    }

    @Test
    fun `onLastClicked() when current page index is greater than 0 view should showLast()`() {

        whenever(mockView.getPageIndex()).thenReturn(1)

        presenter.onLastClicked()

        verify(mockView).showLast()
    }

    @Test
    fun `onLastClicked() when current page index is greater than 0 view should updatePageNumber()`() {

        whenever(mockView.getPageIndex()).thenReturn(1)

        presenter.onLastClicked()

        verify(mockView).updatePageNumber()
    }

    @Test
    fun `onLastClicked() when current page index is less or equal to 0 view should never showLast()`() {

        whenever(mockView.getPageIndex()).thenReturn(0)

        presenter.onLastClicked()

        verify(mockView, never()).showLast()
    }

    @Test
    fun `onLastClicked() when current page index is less or equal to 0 view should never updatePageNumber()`() {

        whenever(mockView.getPageIndex()).thenReturn(0)

        presenter.onLastClicked()

        verify(mockView, never()).updatePageNumber()
    }

    @Test
    fun `onNextClicked() when current page index is less than the last page index view should showNext()`() {

        val mockSize = 10

        whenever(mockView.getSize()).thenReturn(mockSize)
        whenever(mockView.getPageIndex()).thenReturn(mockSize - 2)

        presenter.onNextClicked()

        verify(mockView).showNext()
    }

    @Test
    fun `onNextClicked() when current page index is less than the last page index view should updatePageNumber()`() {

        val mockSize = 10

        whenever(mockView.getSize()).thenReturn(mockSize)
        whenever(mockView.getPageIndex()).thenReturn(mockSize - 2)

        presenter.onNextClicked()

        verify(mockView).updatePageNumber()
    }

    @Test
    fun `onNextClicked() when current page index is greater or equal to the last page index view should never showNext()`() {

        val mockSize = 10

        whenever(mockView.getSize()).thenReturn(mockSize)
        whenever(mockView.getPageIndex()).thenReturn(mockSize - 1)

        presenter.onNextClicked()

        verify(mockView, never()).showNext()
    }

    @Test
    fun `onNextClicked() when current page index is greater or equal to the last page index view should never updatePageNumber()`() {

        val mockSize = 10

        whenever(mockView.getSize()).thenReturn(mockSize)
        whenever(mockView.getPageIndex()).thenReturn(mockSize - 1)

        presenter.onNextClicked()

        verify(mockView, never()).updatePageNumber()
    }
}