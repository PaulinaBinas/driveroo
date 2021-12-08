package com.pbinas.driveroo.data.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    var name: String,
    var surname: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
