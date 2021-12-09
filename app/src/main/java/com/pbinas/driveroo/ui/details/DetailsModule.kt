package com.pbinas.driveroo.ui.details

import com.pbinas.driveroo.ui.details.interactor.DetailsInteractor
import com.pbinas.driveroo.ui.details.interactor.DetailsInteractorImpl
import com.pbinas.driveroo.ui.details.presenter.DetailsPresenter
import com.pbinas.driveroo.ui.details.presenter.DetailsPresenterImpl
import com.pbinas.driveroo.ui.details.view.DetailsView
import dagger.Module
import dagger.Provides

@Module
class DetailsModule {

    @Provides
    internal fun provideDetailsInteractor(interactor: DetailsInteractorImpl): DetailsInteractor = interactor

    @Provides
    internal fun provideDetailsPresenter(presenter: DetailsPresenterImpl<DetailsView, DetailsInteractor>): DetailsPresenter<DetailsView, DetailsInteractor> = presenter
}