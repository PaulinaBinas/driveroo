package com.pbinas.driveroo.ui.chooseDelegationType.presenter

import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.chooseDelegationType.interactor.ChooseDelegationTypeInteractor
import com.pbinas.driveroo.ui.chooseDelegationType.view.ChooseDelegationTypeView

interface ChooseDelegationTypePresenter<V: ChooseDelegationTypeView, I: ChooseDelegationTypeInteractor>: Presenter<V, I> {
}