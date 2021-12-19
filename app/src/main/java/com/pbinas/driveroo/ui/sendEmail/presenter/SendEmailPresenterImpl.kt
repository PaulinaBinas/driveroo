package com.pbinas.driveroo.ui.sendEmail.presenter

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailIntercator
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailActivity
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailView
import com.pbinas.driveroo.util.ExcelUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SendEmailPresenterImpl<V: SendEmailView, I: SendEmailIntercator> @Inject internal
constructor(interactor: I): BasePresenter<V, I> (interactor = interactor), SendEmailPresenter<V, I> {

    override fun sendData() {
        var view = getView()
        view?.getChosenMonths()

        interactor?.let {
            GlobalScope.launch {
                var drives = it.getDrivesForMonth("12-2021")
                drives = drives.sortedWith(compareBy(Drive::date))
                var user = it.getUser()
                ExcelUtil.createNewFile(view as SendEmailActivity, drives, user)
            }
        }
    }

}