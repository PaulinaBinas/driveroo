package com.pbinas.driveroo.ui.base.presenter

import com.pbinas.driveroo.ui.base.interactor.Interactor
import com.pbinas.driveroo.ui.base.view.BaseView

abstract class BasePresenter<V: BaseView, I: Interactor> internal constructor(protected var interactor: I?):
    Presenter<V, I> {

    internal var view: V? = null

    override fun getView(): V? = view

    override fun onAttach(view: V?) {
        this.view = view
    }
}