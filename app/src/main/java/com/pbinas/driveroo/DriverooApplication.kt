package com.pbinas.driveroo

import android.app.Application
import com.pbinas.driveroo.di.DaggerAppComponent

class DriverooApplication: Application() {
//
//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    //override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}