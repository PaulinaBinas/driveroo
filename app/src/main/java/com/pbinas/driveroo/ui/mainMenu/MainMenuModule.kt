package com.pbinas.driveroo.ui.mainMenu

import com.pbinas.driveroo.ui.main.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.main.interactor.MainMenuInteractorImpl
import com.pbinas.driveroo.ui.main.presenter.MainMenuPresenter
import com.pbinas.driveroo.ui.main.presenter.MainMenuPresenterImpl
import com.pbinas.driveroo.ui.main.view.MainMenuView
import dagger.Module
import dagger.Provides

//@Module
class MainMenuModule {

    //@Provides
    internal fun provideMainInteractor(interactor: MainMenuInteractorImpl): MainMenuInteractor = interactor

    //@Provides
    internal fun provideMainPresenter(presenter: MainMenuPresenterImpl<MainMenuView, MainMenuInteractor>): MainMenuPresenter<MainMenuView, MainMenuInteractor> = presenter

}