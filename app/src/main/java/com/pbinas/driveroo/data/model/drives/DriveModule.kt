package com.pbinas.driveroo.data.model.drives

import dagger.Module
import dagger.Provides

@Module
class DriveModule {

    @Provides
    fun provideDriveRepository(repository: DriveRepositoryImpl): DriveRepository = repository
}