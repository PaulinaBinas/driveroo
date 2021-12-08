package com.pbinas.driveroo.ui.main.presenter

import android.app.Activity
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.main.interactor.MainInteractor
import com.pbinas.driveroo.ui.main.view.MainView

interface MainPresenter<V: MainView, I: MainInteractor>: Presenter<V, I> {

    fun registerUser(context: Activity, firstName: String, surname: String)

}