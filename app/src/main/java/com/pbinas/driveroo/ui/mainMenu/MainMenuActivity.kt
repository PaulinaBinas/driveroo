package com.pbinas.driveroo.ui.mainMenu

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.addNewEntry.view.AddNewEntryActivity
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.base.view.BaseView
import com.pbinas.driveroo.ui.browse.BrowseActivity

class MainMenuActivity : BaseActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun browseEntries(view: View) {
        var intent = Intent(this, BrowseActivity::class.java)
        startActivity(intent)
    }

    fun addRide(view: View) {
        var intent = Intent(this, AddNewEntryActivity::class.java)
        startActivity(intent)
    }
}