package com.pbinas.driveroo.ui.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        //this.injectDependencies()
        super.onCreate(savedInstanceState)
    }

    //private fun injectDependencies() = AndroidInjection.inject(this)
}