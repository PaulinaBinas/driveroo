package com.pbinas.driveroo.ui.sendEmail.presenter

import android.content.Context
import com.pbinas.driveroo.databinding.ActivitySendEmailBinding
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailIntercator
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailView

interface SendEmailPresenter<V: SendEmailView, I: SendEmailIntercator>: Presenter<V, I> {

    fun sendData(binding: ActivitySendEmailBinding)

    fun setViewValues(binding: ActivitySendEmailBinding, context: Context)
}