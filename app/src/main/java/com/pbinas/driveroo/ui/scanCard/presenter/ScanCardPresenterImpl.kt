package com.pbinas.driveroo.ui.scanCard.presenter

import com.pbinas.driveroo.ui.scanCard.interactor.ScanCardInteractor
import com.pbinas.driveroo.ui.scanCard.view.ScanCardView
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import javax.inject.Inject

class ScanCardPresenterImpl<V: ScanCardView, I: ScanCardInteractor> @Inject internal constructor
    (interactor: I): BasePresenter<V, I>(interactor = interactor), ScanCardPresenter<V, I>{
}