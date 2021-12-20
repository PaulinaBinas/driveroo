package com.pbinas.driveroo.ui.sendEmail.interactor

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.drives.DriveRepository
import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.data.model.user.UserRepository
import javax.inject.Inject

class SendEmailInteractorImpl @Inject internal constructor(var userRepository: UserRepository, var driveRepository: DriveRepository): SendEmailIntercator {

    override fun getUser(): User {
        return userRepository.getUserById(1)
    }

    override fun getDrivesForMonth(monthAndYear: String): List<Drive> {
        return driveRepository.getDrivesByDate(monthAndYear)
    }

    override fun getAllDrives(): List<Drive> {
        return driveRepository.getDrivesList()
    }
}