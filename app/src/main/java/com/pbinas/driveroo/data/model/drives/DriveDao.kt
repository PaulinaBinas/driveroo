package com.pbinas.driveroo.data.model.drives

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface DriveDao {

    @Insert(onConflict = REPLACE)
    fun saveDrive(drive: Drive)

    @Query("SELECT * FROM Drive")
    fun getAllEntries(): List<Drive>

    @Query("SELECT * FROM Drive WHERE id=:id LIMIT 1")
    fun getDriveById(id: Int): Drive
}