package com.pbinas.driveroo.ui.mainMenu.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.addNewEntry.AddNewEntryMenuActivity
import com.pbinas.driveroo.ui.browse.BrowseActivity
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.main.view.MainMenuView

class MainMenuActivity : BaseActivity(), MainMenuView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun browseEntries(view: View) {
        var intent = Intent(this, BrowseActivity::class.java)
        startActivity(intent)
    }

    fun addRide(view: View) {
        var intent = Intent(this, AddNewEntryMenuActivity::class.java)
        startActivity(intent)
    }
}