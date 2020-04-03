package com.onik.pagedtextapp.presentation.di.component

import com.onik.pagedtextapp.domain.di.component.DomainComponent
import com.onik.pagedtextapp.di.scope.ActivityScope
import com.onik.pagedtextapp.presentation.PagedTextActivity
import com.onik.pagedtextapp.presentation.di.module.PagedTextModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [DomainComponent::class],
    modules = [PagedTextModule::class]
)
interface PagedTextComponent {
    fun inject(activity: PagedTextActivity)
}