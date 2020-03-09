package com.onik.pagedtextapp.presentation.di

import com.onik.pagedtextapp.di.scope.ActivityScope
import com.onik.pagedtextapp.presentation.PagedTextActivity
import com.onik.pagedtextapp.util.di.UtilComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [UtilComponent::class],
    modules = [PagedTextModule::class]
)
interface PagedTextComponent {
    fun inject(activity: PagedTextActivity)
}