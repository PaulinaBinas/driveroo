package com.pbinas.driveroo.data.model.drives

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DriveDao {

    @Insert
    fun saveDrive(drive: Drive)

    @Query("SELECT * FROM Drives")
    fun getAllEntries(): List<Drive>
}