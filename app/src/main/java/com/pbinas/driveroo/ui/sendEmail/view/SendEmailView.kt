package com.pbinas.driveroo.ui.sendEmail.view

import com.pbinas.driveroo.ui.base.view.BaseView

interface SendEmailView: BaseView {

    fun getChosenMonths(): List<String>
    fun playAnimation()
    fun stopAnimation()
}