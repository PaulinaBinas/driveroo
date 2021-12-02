package com.pbinas.driveroo.data.model.drives

//import javax.inject.Inject

class DriveRepositoryImpl internal constructor(var driveDao: DriveDao): DriveRepository {

    override fun addDrive(drive: Drive) {
        driveDao.saveDrive(drive)
    }

    override fun getDrivesList(): List<Drive> {
        return driveDao.getAllEntries()
    }
}