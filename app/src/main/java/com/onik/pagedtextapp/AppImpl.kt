package com.onik.pagedtextapp

import android.app.Application
import com.onik.pagedtextapp.di.component.DaggerDataComponent
import com.onik.pagedtextapp.di.component.DaggerDomainComponent
import com.onik.pagedtextapp.di.component.DataComponent
import com.onik.pagedtextapp.di.component.DomainComponent
import com.onik.pagedtextapp.util.di.UtilComponent
import com.onik.pagedtextapp.util.di.UtilComponentBuilder

class AppImpl : Application(), App {

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
}