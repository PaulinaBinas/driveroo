package com.pbinas.driveroo.ui.addNewEntry.presenter

import android.app.Activity
import com.pbinas.driveroo.ui.addNewEntry.interactor.AddNewEntryInteractor
import com.pbinas.driveroo.ui.addNewEntry.view.AddNewEntryView
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.util.RideType

interface AddNewEntryPresenter<V: AddNewEntryView, I: AddNewEntryInteractor>: Presenter<V, I> {

    fun goFurther(context: Activity, type: RideType)
}