package com.onik.pagedtextapp.data.di

import com.onik.pagedtextapp.data.repo.TextRepo
import com.onik.pagedtextapp.data.repo.TextRepoImpl
import dagger.Module
import dagger.Provides

@Module
class RepoModule {

    @Provides
    fun provideTextRepo(repo: TextRepoImpl): TextRepo = repo
}