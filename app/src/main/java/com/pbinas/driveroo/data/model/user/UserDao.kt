package com.pbinas.driveroo.data.model.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM User WHERE User.id = :id")
    fun getUserById(id: Long): User
}