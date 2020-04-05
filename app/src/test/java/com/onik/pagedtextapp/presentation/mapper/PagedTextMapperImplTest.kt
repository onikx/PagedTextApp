package com.onik.pagedtextapp.presentation.mapper

import com.onik.pagedtextapp.entity.Data
import com.onik.pagedtextapp.presentation.data.ViewState
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class PagedTextMapperImplTest {
    private val mapper = PagedTextMapperImpl()

    @Test
    fun `map Data_Value to ViewState_Data`() {
        val mockText = "Text"
        val given = Data.Value(mockText)

        val mapped = mapper.map(given)

        assertTrue(mapped is ViewState.Data)
        assertEquals(mockText, (mapped as ViewState.Data).data)
    }

    @Test
    fun `map Data_Error to ViewState_Error`() {
        val mockError = Exception()
        val given = Data.Error(mockError)

        val mapped = mapper.map(given)

        assertTrue(mapped is ViewState.Error)
        assertEquals(mockError.toString(), (mapped as ViewState.Error).message)
    }
}