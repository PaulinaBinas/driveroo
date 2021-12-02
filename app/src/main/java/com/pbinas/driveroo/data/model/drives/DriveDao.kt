package com.pbinas.driveroo.data.model.drives

//@Dao
interface DriveDao {

    //@Insert
    fun saveDrive(drive: Drive)

    //@Query("SELECT * FROM Drives")
    fun getAllEntries(): List<Drive>
}