package com.pbinas.driveroo.ui.chooseDelegationType.presenter

import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.chooseDelegationType.interactor.ChooseDelegationTypeInteractor
import com.pbinas.driveroo.ui.chooseDelegationType.view.ChooseDelegationTypeView
import javax.inject.Inject

class ChooseDelegationTypePresenterImpl<V: ChooseDelegationTypeView, I: ChooseDelegationTypeInteractor>
@Inject internal constructor(interactor: I): BasePresenter<V, I> (interactor = interactor), ChooseDelegationTypePresenter<V, I> {
}