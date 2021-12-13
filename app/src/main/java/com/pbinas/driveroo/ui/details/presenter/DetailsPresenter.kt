package com.pbinas.driveroo.ui.details.presenter

import android.app.Activity
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.details.interactor.DetailsInteractor
import com.pbinas.driveroo.ui.details.view.DetailsView

interface DetailsPresenter<V: DetailsView, I: DetailsInteractor>: Presenter<V, I> {

    fun saveDrive(context: Activity, drive: Drive)

    fun loadDriveById(id: Int)

    fun getTypeText(type: String): String
}