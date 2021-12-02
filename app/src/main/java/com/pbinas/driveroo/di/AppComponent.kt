package com.pbinas.driveroo.di

import com.pbinas.driveroo.DriverooApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun inject(application: DriverooApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: DriverooApplication): Builder

        fun build(): AppComponent
    }
}