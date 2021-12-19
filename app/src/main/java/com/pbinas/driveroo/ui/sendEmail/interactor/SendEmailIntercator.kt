package com.pbinas.driveroo.ui.sendEmail.interactor

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.ui.base.interactor.Interactor

interface SendEmailIntercator: Interactor {

    fun getUser(): User
    fun getDrivesForMonth(monthAndYear: String): List<Drive>
}