package com.pbinas.driveroo.data.model.drives

//@Module
class DriveModule {

    //@Provides
    fun provideDriveRepository(repository: DriveRepositoryImpl): DriveRepository = repository
}