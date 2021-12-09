package com.pbinas.driveroo.ui.details.interactor

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.drives.DriveRepository
import javax.inject.Inject

class DetailsInteractorImpl @Inject internal constructor(var driveRepository: DriveRepository): DetailsInteractor {

    override fun saveDrive(drive: Drive) {
        driveRepository.addDrive(drive)
    }
}