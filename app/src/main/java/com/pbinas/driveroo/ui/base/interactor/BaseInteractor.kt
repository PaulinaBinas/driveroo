package com.pbinas.driveroo.ui.base.interactor

import com.pbinas.driveroo.data.model.user.User


open class BaseInteractor(): Interactor {

    protected var user: User? = null

    fun getCurrentUser() = user

    open fun setCurrentUser(user: User) {
        this.user = user
    }
}