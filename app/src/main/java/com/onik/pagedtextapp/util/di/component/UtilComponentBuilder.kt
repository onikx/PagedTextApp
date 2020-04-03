package com.onik.pagedtextapp.util.di.component

import android.content.Context

class UtilComponentBuilder {
    fun create(context: Context): UtilComponent =
        DaggerInnerUtilComponent.builder()
            .context(context)
            .build()
}