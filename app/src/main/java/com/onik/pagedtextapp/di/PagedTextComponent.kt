package com.onik.pagedtextapp.di

import com.onik.pagedtextapp.PagedTextActivity
import dagger.Component

@Component(modules = [PagedTextModule::class])
interface PagedTextComponent {
    fun inject(activity: PagedTextActivity)
}