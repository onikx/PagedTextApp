package com.onik.pagedtextapp

import com.onik.pagedtextapp.data.di.component.DataComponent
import com.onik.pagedtextapp.domain.di.component.DomainComponent
import com.onik.pagedtextapp.builder.UiComponentBuilder
import com.onik.pagedtextapp.util.di.component.UtilComponent

interface App {
    val uiComponentBuilder: UiComponentBuilder
    val dataComponent: DataComponent
    val domainComponent: DomainComponent
    val utilComponent: UtilComponent
}