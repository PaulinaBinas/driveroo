package com.pbinas.driveroo.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuActivity
import com.pbinas.driveroo.ui.base.view.BaseActivity

class MainActivity : BaseActivity(), MainMenuView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun saveNames(view: View) {
        var intent = Intent(this, MainMenuActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}