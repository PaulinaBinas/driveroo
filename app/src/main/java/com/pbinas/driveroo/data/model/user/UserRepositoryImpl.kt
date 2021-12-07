package com.pbinas.driveroo.data.model.user

import javax.inject.Inject

class UserRepositoryImpl @Inject internal constructor(var userDao: UserDao): UserRepository {

    override fun addUser(user: User) {
        userDao.addUser(user)
    }

    override fun getUserById(id: Long): User {
        return userDao.getUserById(id)
    }
}