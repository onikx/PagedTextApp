package com.onik.pagedtextapp.presentation.di.component

import com.onik.pagedtextapp.di.scope.ActivityScope
import com.onik.pagedtextapp.presentation.di.module.TestPagedTextModule
import dagger.Component

@ActivityScope
@Component(
    modules = [TestPagedTextModule::class]
)
interface TestPagedTextComponent : PagedTextComponent