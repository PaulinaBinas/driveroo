package com.pbinas.driveroo.data.model

import com.pbinas.driveroo.data.model.drives.DriveDao

//@Module
class DatabaseModule {

    //@Provides
    fun provideDriveDao(db: ApplicationDatabase): DriveDao = db.driveDao()

    /*@Provides
    fun provideDatabase(context: Application): ApplicationDatabase = Room
        .databaseBuilder(context, ApplicationDatabase::class.java, "driveroo-database")
        .build()
     */
}