package com.pbinas.driveroo.ui.main.interactor

import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.ui.base.interactor.Interactor


interface MainInteractor: Interactor {

    fun saveUser(user: User)
}