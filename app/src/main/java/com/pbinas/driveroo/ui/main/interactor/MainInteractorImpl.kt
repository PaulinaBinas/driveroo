package com.pbinas.driveroo.ui.main.interactor

import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.data.model.user.UserRepository
import javax.inject.Inject

class MainInteractorImpl @Inject internal constructor(var userRepository: UserRepository): MainInteractor {

    override fun saveUser(user: User) {
        userRepository.addUser(user)
    }

    override fun getUser(): User? {
        return userRepository.getUserById(1)
    }

}