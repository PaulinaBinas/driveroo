package com.pbinas.driveroo.data.model.user

import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun provideUserRepository(repository: UserRepositoryImpl): UserRepository = repository
}