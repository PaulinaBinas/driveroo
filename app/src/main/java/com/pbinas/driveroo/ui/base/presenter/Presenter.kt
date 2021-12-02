package com.pbinas.driveroo.ui.base.presenter

import com.pbinas.driveroo.ui.base.interactor.Interactor
import com.pbinas.driveroo.ui.base.view.BaseView

interface Presenter<V: BaseView, I: Interactor> {

    fun getView(): V?

    fun onAttach(view: V?)
}