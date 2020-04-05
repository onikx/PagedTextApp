package com.onik.pagedtextapp.data.mapper

import com.onik.pagedtextapp.entity.Data
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class DataMapperImplTest {
    private val mapper = DataMapperImpl()

    @Test
    fun `map String to Data_Value`() {
        val given = "Text"

        val mapped = mapper.map(given)

        assertTrue(mapped is Data.Value)
        assertEquals(given, (mapped as Data.Value).value)
    }

    @Test
    fun `map Throwable to Data_Error`() {
        val given = Throwable()

        val mapped = mapper.map(given)

        assertTrue(mapped is Data.Error)
        assertEquals(given, (mapped as Data.Error).error)
    }
}