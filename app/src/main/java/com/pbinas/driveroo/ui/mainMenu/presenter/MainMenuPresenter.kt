package com.pbinas.driveroo.ui.main.presenter

import com.pbinas.driveroo.ui.main.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.main.view.MainMenuView

interface MainMenuPresenter<V: MainMenuView, I: MainMenuInteractor>: Presenter<V, I> {

}