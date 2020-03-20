package com.onik.pagedtextapp.di.component

import com.onik.pagedtextapp.data.di.RepoComponent
import com.onik.pagedtextapp.data.di.RepoModule
import com.onik.pagedtextapp.util.di.UtilComponent
import dagger.Component

@Component(
    dependencies = [UtilComponent::class],
    modules = [RepoModule::class]
)
interface DataComponent : RepoComponent