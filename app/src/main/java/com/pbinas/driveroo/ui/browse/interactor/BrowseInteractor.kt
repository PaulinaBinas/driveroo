package com.pbinas.driveroo.ui.browse.interactor

import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.ui.base.interactor.Interactor

interface BrowseInteractor: Interactor {

    fun getAllDrives(): List<Drive>
}