package com.pbinas.driveroo.ui.scanCard.presenter

import com.pbinas.driveroo.ui.scanCard.interactor.ScanCardInteractor
import com.pbinas.driveroo.ui.scanCard.view.ScanCardView
import com.pbinas.driveroo.ui.base.presenter.Presenter

interface ScanCardPresenter<V: ScanCardView, I: ScanCardInteractor>: Presenter<V, I> {
}