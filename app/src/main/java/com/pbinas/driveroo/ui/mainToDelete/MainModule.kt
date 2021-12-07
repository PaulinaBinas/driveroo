package com.pbinas.driveroo.ui.mainToDelete

import com.pbinas.driveroo.ui.mainToDelete.interactor.MainInteractor
import com.pbinas.driveroo.ui.mainToDelete.interactor.MainInteractorImpl
import com.pbinas.driveroo.ui.mainToDelete.presenter.MainPresenter
import com.pbinas.driveroo.ui.mainToDelete.presenter.MainPresenterImpl
import com.pbinas.driveroo.ui.mainToDelete.view.MainView
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    internal fun provideMainInteractor(interactor: MainInteractorImpl): MainInteractor = interactor

    @Provides
    internal fun provideMainPresenter(presenter: MainPresenterImpl<MainView, MainInteractor>): MainPresenter<MainView, MainInteractor> = presenter

}