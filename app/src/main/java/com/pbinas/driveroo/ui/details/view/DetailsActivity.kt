package com.pbinas.driveroo.ui.details.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.data.model.drives.Drive
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.details.interactor.DetailsInteractor
import com.pbinas.driveroo.ui.details.presenter.DetailsPresenter
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsView {
    @Inject
    lateinit var presenter: DetailsPresenter<DetailsView, DetailsInteractor>
    private var type = ""
    override fun setType(type: String) {
        this.type = type
    }

    private var date = ""
    override fun setDate(date: String) {
        this.date = date
    }

    private var time = ""
    override fun setTime(time: String) {
        this.time = time
    }

    private var country = ""
    override fun setCountry(country: String) {
        this.country = country
    }

    var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras?.getString("type") ?: ""
        date = intent.extras?.getString("date") ?: ""
        time = intent.extras?.getString("time") ?: ""
        country = intent.extras?.getString("country") ?: ""
        id = intent.extras?.getInt("id", -1)
        setContentView(R.layout.activity_details)
        presenter.onAttach(this)
        if (id != null && id!! > -1) {
            presenter.loadDriveById(id!!)
            showEditButton()
        } else {
            showSaveButton()
            setValues()
        }
    }

    fun saveEntry(view: View) {
        var drive = Drive(type, time, date, country)
        this.presenter.saveDrive(this, drive)
    }

    override fun setValues() {
        var typeText : TextView = findViewById(R.id.typeText)
        var dateText : TextView = findViewById(R.id.dateText)
        var timeText : TextView = findViewById(R.id.timeText)
        var countryText : TextView = findViewById(R.id.countryText)

        typeText.text = presenter.getTypeText(type)
        dateText.text = date
        timeText.text = time
        countryText.text = country
    }

    private fun showSaveButton() {
        var editButton: Button = findViewById(R.id.editButton)
        editButton.visibility = View.INVISIBLE
        var saveButton: Button = findViewById(R.id.saveButton)
        saveButton.visibility = View.VISIBLE
    }

    private fun showEditButton() {
        var saveButton: Button = findViewById(R.id.saveButton)
        saveButton.visibility = View.INVISIBLE
        var editButton: Button = findViewById(R.id.editButton)
        editButton.visibility = View.VISIBLE
    }
}