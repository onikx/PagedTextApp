package com.onik.pagedtextapp.data.di.module

import com.onik.pagedtextapp.data.mapper.DataMapper
import com.onik.pagedtextapp.data.mapper.DataMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideDataMapper(mapper: DataMapperImpl): DataMapper = mapper
}