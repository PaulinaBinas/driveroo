package com.pbinas.driveroo.data.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class User (
    var name: String,
    var surname: String,
    var company: String
) {
    @PrimaryKey @NotNull var id = 1
}
