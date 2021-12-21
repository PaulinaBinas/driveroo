package com.pbinas.driveroo.ui.mainMenu

import com.pbinas.driveroo.ui.mainMenu.interactor.MainMenuInteractor
import com.pbinas.driveroo.ui.mainMenu.interactor.MainMenuInteractorImpl
import com.pbinas.driveroo.ui.mainMenu.presenter.MainMenuPresenter
import com.pbinas.driveroo.ui.mainMenu.presenter.MainMenuPresenterImpl
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuView
import dagger.Module
import dagger.Provides

@Module
class MainMenuModule {

    @Provides
    internal fun provideMainMenuInteractor(interactor: MainMenuInteractorImpl): MainMenuInteractor = interactor

    @Provides
    internal fun provideMainMenuPresenter(presenter: MainMenuPresenterImpl<MainMenuView, MainMenuInteractor>): MainMenuPresenter<MainMenuView, MainMenuInteractor> = presenter
}