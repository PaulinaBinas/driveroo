package com.pbinas.driveroo.data.model.user

interface UserRepository {

    fun addUser(user: User)

    fun getUserById(id: Long): User
}