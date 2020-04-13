package com.onik.pagedtextapp

import android.app.Application
import com.onik.pagedtextapp.data.di.component.DaggerDataComponent
import com.onik.pagedtextapp.data.di.component.DataComponent
import com.onik.pagedtextapp.domain.di.component.DaggerDomainComponent
import com.onik.pagedtextapp.domain.di.component.DomainComponent
import com.onik.pagedtextapp.builder.UiComponentBuilder
import com.onik.pagedtextapp.presentation.di.builder.PagedTextComponentBuilder
import com.onik.pagedtextapp.presentation.di.builder.TestPagedTextComponentBuilderImpl
import com.onik.pagedtextapp.util.di.component.UtilComponent
import com.onik.pagedtextapp.util.di.component.UtilComponentBuilder

class TestAppImpl : Application(), App {

    override val dataComponent: DataComponent by lazy {
        DaggerDataComponent.builder()
            .utilComponent(utilComponent)
            .build()
    }

    override val domainComponent: DomainComponent by lazy {
        DaggerDomainComponent.builder()
            .repoComponent(dataComponent)
            .build()
    }

    override val utilComponent: UtilComponent by lazy {
        UtilComponentBuilder().create(
            context = this.applicationContext
        )
    }

    override val uiComponentBuilder: UiComponentBuilder by lazy {
        object : UiComponentBuilder {
            override val pagedTextComponentBuilder: PagedTextComponentBuilder by lazy {
                TestPagedTextComponentBuilderImpl()
            }
        }
    }
}