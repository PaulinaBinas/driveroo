package com.pbinas.driveroo.ui.browse

import com.pbinas.driveroo.ui.browse.interactor.BrowseInteractor
import com.pbinas.driveroo.ui.browse.interactor.BrowseInteractorImpl
import com.pbinas.driveroo.ui.browse.presenter.BrowsePresenter
import com.pbinas.driveroo.ui.browse.presenter.BrowsePresenterImpl
import com.pbinas.driveroo.ui.browse.view.BrowseView
import dagger.Module
import dagger.Provides

@Module
class BrowseModule {

    @Provides
    internal fun provideBrowseInteractor(interactor: BrowseInteractorImpl): BrowseInteractor = interactor

     @Provides
    internal fun provideBrowsePresenter(presenter: BrowsePresenterImpl<BrowseView, BrowseInteractor>): BrowsePresenter<BrowseView, BrowseInteractor> = presenter
}