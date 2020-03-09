package com.onik.pagedtextapp.util.di

import com.onik.pagedtextapp.util.FileReader
import com.onik.pagedtextapp.util.FileReaderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @Provides
    fun provideTextProvider(provider: FileReaderImpl): FileReader = provider
}