package com.onik.pagedtextapp.presentation.di

import com.onik.pagedtextapp.di.component.DomainComponent
import com.onik.pagedtextapp.di.scope.ActivityScope
import com.onik.pagedtextapp.presentation.PagedTextActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [DomainComponent::class],
    modules = [PagedTextModule::class]
)
interface PagedTextComponent {
    fun inject(activity: PagedTextActivity)
}