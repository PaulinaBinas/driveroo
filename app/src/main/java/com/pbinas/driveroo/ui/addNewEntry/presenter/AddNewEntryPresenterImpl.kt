package com.pbinas.driveroo.ui.addNewEntry.presenter

import android.app.Activity
import android.content.Intent
import com.pbinas.driveroo.ui.addNewEntry.interactor.AddNewEntryInteractor
import com.pbinas.driveroo.ui.addNewEntry.view.AddNewEntryView
import com.pbinas.driveroo.ui.base.presenter.BasePresenter
import com.pbinas.driveroo.ui.chooseTime.ChooseTimeActivity
import com.pbinas.driveroo.util.RideType
import javax.inject.Inject

class AddNewEntryPresenterImpl<V: AddNewEntryView, I: AddNewEntryInteractor> @Inject internal
constructor(interactor: I): BasePresenter<V, I> (interactor = interactor), AddNewEntryPresenter<V, I> {

    override fun goFurther(context: Activity, type: RideType) {
        var intent = Intent(context, ChooseTimeActivity::class.java)
        intent.putExtra("type", type.name)
        var view: AddNewEntryView = getView() as AddNewEntryView
        if(view.getId() != null && view.getId()!! > -1) {
            intent.putExtra("id", view.getId())
            intent.putExtra("date", view.getDate())
            intent.putExtra("time", view.getTime())
            intent.putExtra("country", view.getCountry())
        }
        context.startActivity(intent)
    }
}