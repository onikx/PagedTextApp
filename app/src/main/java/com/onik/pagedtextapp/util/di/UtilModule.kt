package com.onik.pagedtextapp.util.di

import com.onik.pagedtextapp.util.TextProvider
import com.onik.pagedtextapp.util.TextProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @Provides
    fun provideTextProvider(provider: TextProviderImpl): TextProvider = provider
}