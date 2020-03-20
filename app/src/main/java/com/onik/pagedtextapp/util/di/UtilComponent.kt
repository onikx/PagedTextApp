package com.onik.pagedtextapp.util.di

import com.onik.pagedtextapp.util.provider.TextProvider

interface UtilComponent {
    val textProvider: TextProvider
}