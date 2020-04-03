package com.onik.pagedtextapp.data.di.module

import com.onik.pagedtextapp.data.repo.TextRepo
import com.onik.pagedtextapp.data.repo.TextRepoImpl
import dagger.Module
import dagger.Provides

@Module(
    includes = [MapperModule::class]
)
class RepoModule {

    @Provides
    fun provideTextRepo(repo: TextRepoImpl): TextRepo = repo
}