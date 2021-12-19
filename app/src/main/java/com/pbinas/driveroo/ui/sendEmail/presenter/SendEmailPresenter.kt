package com.pbinas.driveroo.ui.sendEmail.presenter

import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailIntercator
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailView

interface SendEmailPresenter<V: SendEmailView, I: SendEmailIntercator>: Presenter<V, I> {

    fun sendData()
}