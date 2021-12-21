package com.pbinas.driveroo.ui.details.presenter

import android.app.Activity
import android.content.Intent
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.details.interactor.DetailsInteractor
import com.pbinas.driveroo.ui.details.view.DetailsView
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenterImpl<V: DetailsView, I: DetailsInteractor> @Inject internal
constructor(interactor: I): BasePresenter<V, I> (interactor = interactor), DetailsPresenter<V, I> {

    override fun saveDrive(context: Activity, drive: Drive) {
        interactor?.let {
            GlobalScope.launch {
                it.saveDrive(drive)
            }
        }

        var intent = Intent(context, MainMenuActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
        context.finish()
    }

    override fun loadDriveById(id: Int) {
        var drive: Drive? = null
        interactor?.let {
            var run = GlobalScope.launch {
                drive = it.loadDrive(id)
            }
            while(!run.isCompleted) {}
            if (drive != null) {
                var view = (getView() as DetailsView)
                view.setType(drive!!.type)
                view.setTime(drive!!.time)
                view.setDate(drive!!.date)
                view.setCountry(drive!!.country)
                view.setValues()
            }
        }
    }

    override fun getTypeText(type: String): String {
        return when(type) {
            "LOADING" -> "Załadunek"
            "UNLOADING" -> "Rozładunek"
            else -> ""
        }
    }

    override fun deleteDrive(id: Int) {
        interactor?.let {
            var run = GlobalScope.launch {
                it.deleteBrive(id)
            }
            while (!run.isCompleted) {
                ; //wait
            }
        }
    }
}