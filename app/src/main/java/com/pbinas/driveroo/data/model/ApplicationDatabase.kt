package com.pbinas.driveroo.data.model

import com.pbinas.driveroo.data.model.drives.DriveDao

//@Database(entities = [(Drive::class)], version = 1)
abstract class ApplicationDatabase//: RoomDatabase() {
{abstract fun driveDao(): DriveDao
}