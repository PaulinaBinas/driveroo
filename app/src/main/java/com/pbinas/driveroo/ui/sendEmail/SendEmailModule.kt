package com.pbinas.driveroo.ui.sendEmail

import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailInteractorImpl
import com.pbinas.driveroo.ui.sendEmail.interactor.SendEmailIntercator
import com.pbinas.driveroo.ui.sendEmail.presenter.SendEmailPresenter
import com.pbinas.driveroo.ui.sendEmail.presenter.SendEmailPresenterImpl
import com.pbinas.driveroo.ui.sendEmail.view.SendEmailView
import dagger.Module
import dagger.Provides

@Module
class SendEmailModule {

    @Provides
    internal fun provideSendEmailInteractor(interactor: SendEmailInteractorImpl): SendEmailIntercator = interactor

    @Provides
    internal fun provideSendEmailPresenter(presenter: SendEmailPresenterImpl<SendEmailView, SendEmailIntercator>): SendEmailPresenter<SendEmailView, SendEmailIntercator> = presenter
}