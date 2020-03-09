package com.onik.pagedtextapp

import android.app.Application
import com.onik.pagedtextapp.util.di.UtilComponent
import com.onik.pagedtextapp.util.di.UtilComponentBuilder

class AppImpl : Application(), App {

    override val utilComponent: UtilComponent by lazy {
        UtilComponentBuilder().create(
            context = this.applicationContext
        )
    }
}