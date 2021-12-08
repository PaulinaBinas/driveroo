package com.pbinas.driveroo.ui.addNewEntry.view

import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.addNewEntry.interactor.AddNewEntryInteractor
import com.pbinas.driveroo.ui.addNewEntry.presenter.AddNewEntryPresenter
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.util.RideType
import javax.inject.Inject

class AddNewEntryActivity : BaseActivity(), AddNewEntryView {
    @Inject
    lateinit var presenter: AddNewEntryPresenter<AddNewEntryView, AddNewEntryInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_entry_menu)
    }

    fun goFurtherLoading(view: View) {
        presenter.goFurther(this, RideType.LOADING)
    }

    fun goFurtherUnloading(view: View) {
        presenter.goFurther(this, RideType.UNLOADING)
    }
}