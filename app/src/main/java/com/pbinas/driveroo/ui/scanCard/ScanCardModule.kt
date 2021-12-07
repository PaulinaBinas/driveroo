package com.pbinas.driveroo.ui.scanCard

import com.pbinas.driveroo.ui.scanCard.interactor.ScanCardInteractor
import com.pbinas.driveroo.ui.scanCard.interactor.ScanCardInteractorImpl
import com.pbinas.driveroo.ui.scanCard.presenter.ScanCardPresenter
import com.pbinas.driveroo.ui.scanCard.presenter.ScanCardPresenterImpl
import com.pbinas.driveroo.ui.scanCard.view.ScanCardView
import dagger.Module
import dagger.Provides

@Module
class ScanCardModule {

    @Provides
    internal fun provideScanCardInteractor(): ScanCardInteractor = ScanCardInteractorImpl()

    @Provides
    internal fun provideScanCardPresenter(presenter: ScanCardPresenterImpl<ScanCardView,
            ScanCardInteractor>): ScanCardPresenter<ScanCardView, ScanCardInteractor> = presenter
}