package com.pbinas.driveroo.ui.mainMenu.presenter

import android.app.Activity
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.mainMenu.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuView

interface MainMenuPresenter<V: MainMenuView, I: MainMenuInteractor>: Presenter<V, I> {

    fun setTitleText()

    fun changeName(context: Activity)
}