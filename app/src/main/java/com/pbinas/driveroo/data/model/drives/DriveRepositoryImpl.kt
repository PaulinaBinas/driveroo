package com.pbinas.driveroo.data.model.drives

import javax.inject.Inject

class DriveRepositoryImpl @Inject internal constructor(var driveDao: DriveDao): DriveRepository {

    override fun addDrive(drive: Drive) {
        driveDao.saveDrive(drive)
    }

    override fun getDrivesList(): List<Drive> {
        return driveDao.getAllEntries()
    }

    override fun getDriveById(id: Int): Drive? {
        return driveDao.getDriveById(id)
    }

    override fun deleteDriveById(id: Int) {
        driveDao.deleteEntryById(id)
    }
}