package com.pbinas.driveroo.data.model.drives

interface DriveRepository {

    fun addDrive(drive: Drive)

    fun getDrivesList(): List<Drive>
}