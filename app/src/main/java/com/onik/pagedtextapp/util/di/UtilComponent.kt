package com.onik.pagedtextapp.util.di

import com.onik.pagedtextapp.util.FileReader

interface UtilComponent {
    val textProvider: FileReader
}