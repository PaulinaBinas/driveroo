package com.pbinas.driveroo.ui.chooseDelegationType

import com.pbinas.driveroo.ui.chooseDelegationType.interactor.ChooseDelegationTypeInteractor
import com.pbinas.driveroo.ui.chooseDelegationType.interactor.ChooseDelegationTypeInteractorImpl
import com.pbinas.driveroo.ui.chooseDelegationType.presenter.ChooseDelegationTypePresenter
import com.pbinas.driveroo.ui.chooseDelegationType.presenter.ChooseDelegationTypePresenterImpl
import com.pbinas.driveroo.ui.chooseDelegationType.view.ChooseDelegationTypeView
import dagger.Module
import dagger.Provides

@Module
class ChooseDelegationTypeModule {

    @Provides
    internal fun provideChooseDelegationTypeInteractor(interactor: ChooseDelegationTypeInteractorImpl):
            ChooseDelegationTypeInteractor = interactor

    @Provides
    internal fun provideChooseDelegationTypePresenter(presenter: ChooseDelegationTypePresenterImpl<ChooseDelegationTypeView, ChooseDelegationTypeInteractor>):
            ChooseDelegationTypePresenter<ChooseDelegationTypeView, ChooseDelegationTypeInteractor> = presenter
}