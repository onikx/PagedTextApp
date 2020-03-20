package com.onik.pagedtextapp.di.component

import com.onik.pagedtextapp.data.di.RepoComponent
import com.onik.pagedtextapp.domain.di.UseCaseModule
import com.onik.pagedtextapp.domain.di.UseCaseComponent
import dagger.Component

@Component(
    dependencies = [RepoComponent::class],
    modules = [UseCaseModule::class]
)
interface DomainComponent : UseCaseComponent