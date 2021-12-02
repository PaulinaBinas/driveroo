package com.pbinas.driveroo.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuActivity

class DetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    fun saveEntry(view: View) {
        var intent = Intent(this, MainMenuActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}