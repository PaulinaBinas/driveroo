package com.pbinas.driveroo.ui.mainMenu.presenter

import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.mainMenu.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainMenuPresenterImpl<V: MainMenuView, I: MainMenuInteractor> @Inject internal
constructor(interactor: I): BasePresenter<V, I>(interactor = interactor), MainMenuPresenter<V, I>{

    override fun setTitleText() {
        interactor?.let {
            GlobalScope.launch {
                var user = it.getUser()
                user?.let { u -> (getView() as MainMenuView).setTitle(u.name, u.surname) }
            }
        }
    }
}