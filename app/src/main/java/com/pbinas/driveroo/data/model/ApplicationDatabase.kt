package com.pbinas.driveroo.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.data.model.drives.DriveDao
import com.pbinas.driveroo.data.model.user.User
import com.pbinas.driveroo.data.model.user.UserDao

@Database(entities = [(Drive::class), (User::class)], version = 1)
abstract class ApplicationDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun driveDao(): DriveDao
}