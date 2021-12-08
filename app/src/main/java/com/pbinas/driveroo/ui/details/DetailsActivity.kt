package com.pbinas.driveroo.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.mainMenu.MainMenuActivity

class DetailsActivity : BaseActivity() {
    var type = ""
    var date = ""
    var time = ""
    var country = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras?.getString("type") ?: ""
        date = intent.extras?.getString("date") ?: ""
        time = intent.extras?.getString("time") ?: ""
        country = intent.extras?.getString("country") ?: ""
        setContentView(R.layout.activity_details)
        setValues()
        showSaveButton()

    }

    fun saveEntry(view: View) {
        var intent = Intent(this, MainMenuActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    private fun setValues() {
        var typeText : TextView = findViewById(R.id.typeText)
        var dateText : TextView = findViewById(R.id.dateText)
        var timeText : TextView = findViewById(R.id.timeText)
        var countryText : TextView = findViewById(R.id.countryText)

        typeText.text = type
        dateText.text = date
        timeText.text = time
        countryText.text = country
    }

    private fun showSaveButton() {
        var saveButton: Button = findViewById(R.id.saveButton)
        saveButton.visibility = View.VISIBLE
    }

    private fun ShowEditButton() {

    }
}