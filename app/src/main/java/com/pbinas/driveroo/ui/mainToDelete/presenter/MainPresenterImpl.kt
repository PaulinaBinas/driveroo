package com.pbinas.driveroo.ui.mainToDelete.presenter

import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.mainToDelete.interactor.MainInteractor
import com.pbinas.driveroo.ui.mainToDelete.view.MainView
import javax.inject.Inject

class MainPresenterImpl<V: MainView, I: MainInteractor> @Inject internal constructor(interactor: I): BasePresenter<V, I>(interactor = interactor), MainPresenter<V, I> {

}