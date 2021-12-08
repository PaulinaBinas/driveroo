package com.pbinas.driveroo.ui.main

import com.pbinas.driveroo.ui.main.interactor.MainInteractor
import com.pbinas.driveroo.ui.main.interactor.MainInteractorImpl
import com.pbinas.driveroo.ui.main.presenter.MainPresenter
import com.pbinas.driveroo.ui.main.presenter.MainPresenterImpl
import com.pbinas.driveroo.ui.main.view.MainView
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    internal fun provideMainInteractor(interactor: MainInteractorImpl): MainInteractor = interactor

    @Provides
    internal fun provideMainPresenter(presenter: MainPresenterImpl<MainView, MainInteractor>): MainPresenter<MainView, MainInteractor> = presenter

}