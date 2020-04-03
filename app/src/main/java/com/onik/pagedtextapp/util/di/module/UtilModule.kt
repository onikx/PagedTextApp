package com.onik.pagedtextapp.util.di.module

import com.onik.pagedtextapp.util.provider.TextProvider
import com.onik.pagedtextapp.util.provider.TextProviderImpl
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @Provides
    fun provideTextProvider(provider: TextProviderImpl): TextProvider = provider
}