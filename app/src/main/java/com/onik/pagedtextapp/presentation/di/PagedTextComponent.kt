package com.onik.pagedtextapp.presentation.di

import com.onik.pagedtextapp.presentation.PagedTextActivity
import dagger.Component

@Component(modules = [PagedTextModule::class])
interface PagedTextComponent {
    fun inject(activity: PagedTextActivity)
}