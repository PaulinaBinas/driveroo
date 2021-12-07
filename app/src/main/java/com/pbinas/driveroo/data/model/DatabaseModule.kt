package com.pbinas.driveroo.data.model

import android.app.Application
import androidx.room.Room
import com.pbinas.driveroo.data.model.drives.DriveDao
import com.pbinas.driveroo.data.model.user.UserDao
import dagger.Module
import dagger.Provides


@Module
class DatabaseModule {

    @Provides
    fun provideDriveDao(db: ApplicationDatabase): DriveDao = db.driveDao()

    @Provides
    fun provideUserDao(db: ApplicationDatabase): UserDao = db.userDao()

    @Provides
    fun provideDatabase(context: Application): ApplicationDatabase = Room
        .databaseBuilder(context, ApplicationDatabase::class.java, "driveroo.db")
            //TODO create new db asset and link here
        .createFromAsset("database/tachotest.db")
        .build()
}