package com.onik.pagedtextapp.util.di.component

import android.content.Context
import com.onik.pagedtextapp.util.di.module.UtilModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [UtilModule::class]
)
@Singleton
internal interface InnerUtilComponent :
    UtilComponent {

    @Component.Builder
    interface Builder {
        fun build(): InnerUtilComponent

        @BindsInstance
        fun context(context: Context): Builder
    }
}