package com.pbinas.driveroo.ui.main.presenter

import com.pbinas.driveroo.ui.main.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.main.view.MainMenuView
import javax.inject.Inject

class MainPresenterImpl<V: MainMenuView, I: MainMenuInteractor> @Inject internal constructor(interactor: I): BasePresenter<V, I>(interactor = interactor),
    MainMenuPresenter<V, I> {

}