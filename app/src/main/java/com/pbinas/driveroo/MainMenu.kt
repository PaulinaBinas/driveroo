package com.pbinas.driveroo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun browseEntries(view: View) {}

    fun addRide(view: View) {
        var intent = Intent(this, AddNewEntryMenuActivity::class.java)
        startActivity(intent)
    }
}