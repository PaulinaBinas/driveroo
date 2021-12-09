package com.pbinas.driveroo.ui.browse.interactor

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.drives.DriveRepository
import javax.inject.Inject

class BrowseInteractorImpl @Inject internal constructor(var driveRepository: DriveRepository): BrowseInteractor {

    override fun getAllDrives(): List<Drive> {
        return driveRepository.getDrivesList()
    }
}