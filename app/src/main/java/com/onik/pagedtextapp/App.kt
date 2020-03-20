package com.onik.pagedtextapp

import com.onik.pagedtextapp.di.component.DataComponent
import com.onik.pagedtextapp.di.component.DomainComponent
import com.onik.pagedtextapp.util.di.UtilComponent

interface App {
    val dataComponent: DataComponent
    val domainComponent: DomainComponent
    val utilComponent: UtilComponent
}