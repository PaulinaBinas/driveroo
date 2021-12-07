package com.pbinas.driveroo.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.databinding.ActivityMainBinding
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.mainMenu.view.MainMenuActivity

class MainActivity : BaseActivity(), MainMenuView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun saveNames(view: View) {
        var intent = Intent(this, MainMenuActivity::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}