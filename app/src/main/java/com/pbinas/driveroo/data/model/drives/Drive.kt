package com.pbinas.driveroo.data.model.drives

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Drives")
data class Drive constructor(
    var type: String,
    var time: String,
    var date: String,
    var country: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
