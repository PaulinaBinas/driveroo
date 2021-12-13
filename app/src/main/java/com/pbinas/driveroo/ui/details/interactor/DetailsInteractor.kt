package com.pbinas.driveroo.ui.details.interactor

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.ui.base.interactor.Interactor

interface DetailsInteractor: Interactor {

    fun saveDrive(drive: Drive)

    fun loadDrive(id: Int): Drive?
}