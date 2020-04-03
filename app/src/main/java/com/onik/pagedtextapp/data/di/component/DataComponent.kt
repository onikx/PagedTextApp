package com.onik.pagedtextapp.data.di.component

import com.onik.pagedtextapp.data.di.module.RepoModule
import com.onik.pagedtextapp.util.di.component.UtilComponent
import dagger.Component

@Component(
    dependencies = [UtilComponent::class],
    modules = [RepoModule::class]
)
interface DataComponent : RepoComponent