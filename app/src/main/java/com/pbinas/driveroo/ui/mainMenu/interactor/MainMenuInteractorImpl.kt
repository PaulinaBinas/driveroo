package com.pbinas.driveroo.ui.mainMenu.interactor

import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.data.model.user.UserRepository
import javax.inject.Inject

class MainMenuInteractorImpl @Inject internal constructor(var userRepository: UserRepository): MainMenuInteractor {

    override fun getUser(): User? {
        return userRepository.getUserById(1)
    }
}