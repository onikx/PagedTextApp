package com.onik.pagedtextapp.domain.di.component

import com.onik.pagedtextapp.data.di.component.RepoComponent
import com.onik.pagedtextapp.domain.di.module.UseCaseModule
import dagger.Component

@Component(
    dependencies = [RepoComponent::class],
    modules = [UseCaseModule::class]
)
interface DomainComponent :
    UseCaseComponent