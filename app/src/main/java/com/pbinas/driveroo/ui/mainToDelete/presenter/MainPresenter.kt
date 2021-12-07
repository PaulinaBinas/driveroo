package com.pbinas.driveroo.ui.mainToDelete.presenter

import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.mainToDelete.interactor.MainInteractor
import com.pbinas.driveroo.ui.mainToDelete.view.MainView

interface MainPresenter<V: MainView, I: MainInteractor>: Presenter<V, I> {

}