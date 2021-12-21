package com.pbinas.driveroo.ui.mainMenu.interactor

import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.ui.base.interactor.Interactor

interface MainMenuInteractor: Interactor {

    fun getUser(): User?
}