package com.pbinas.driveroo.data.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey var id: Long,
    var name: String,
    var surname: String,
    var phoneNumber: String,
    var companyName: String
)
