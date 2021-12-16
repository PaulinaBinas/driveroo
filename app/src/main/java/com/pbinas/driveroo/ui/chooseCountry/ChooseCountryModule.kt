package com.pbinas.driveroo.ui.chooseCountry

import com.pbinas.driveroo.ui.chooseCountry.interactor.ChooseCountryInteractor
import com.pbinas.driveroo.ui.chooseCountry.interactor.ChooseCountryInteractorImpl
import com.pbinas.driveroo.ui.chooseCountry.presenter.ChooseCountryPresenter
import com.pbinas.driveroo.ui.chooseCountry.presenter.ChooseCountryPresenterImpl
import com.pbinas.driveroo.ui.chooseCountry.view.ChooseCountryView
import dagger.Module
import dagger.Provides

@Module
class ChooseCountryModule {

    @Provides
    internal fun provideChooseCountryInteractor(interactor: ChooseCountryInteractorImpl):
            ChooseCountryInteractor = interactor

    @Provides
    internal fun provideChooseCountryPresenter(presenter: ChooseCountryPresenterImpl<ChooseCountryView,
            ChooseCountryInteractor>): ChooseCountryPresenter<ChooseCountryView, ChooseCountryInteractor> = presenter
}