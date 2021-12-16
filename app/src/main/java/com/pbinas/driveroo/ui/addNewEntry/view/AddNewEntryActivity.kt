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
    private var id: Int? = null
    private var type: String? = null
    private var date: String? = null
    private var time: String? = null
    private var country: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras?.getString("type") ?: ""
        date = intent.extras?.getString("date") ?: ""
        time = intent.extras?.getString("time") ?: ""
        country = intent.extras?.getString("country") ?: ""
        id = intent.extras?.getInt("id", -1)
        setContentView(R.layout.activity_add_new_entry_menu)
        presenter.onAttach(this)
    }

    fun goFurtherLoading(view: View) {
        presenter.goFurther(this, RideType.LOADING)
    }

    fun goFurtherUnloading(view: View) {
        presenter.goFurther(this, RideType.UNLOADING)
    }

    override fun getId(): Int? {
        return this.id
    }

    override fun getDate(): String? {
        return this.date
    }

    override fun getTime(): String? {
        return this.time
    }

    override fun getCountry(): String? {
        return this.country
    }
}