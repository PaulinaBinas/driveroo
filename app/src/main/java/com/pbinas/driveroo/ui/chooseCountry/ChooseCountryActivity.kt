package com.pbinas.driveroo.ui.chooseCountry

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.details.view.DetailsActivity

class ChooseCountryActivity : BaseActivity() {
    var type = ""
    var date = ""
    var time = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras?.getString("type") ?: ""
        date = intent.extras?.getString("date") ?: ""
        time = intent.extras?.getString("time") ?: ""
        setContentView(R.layout.activity_choose_country)
    }

    fun goFurther(view: View) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("date", date)
        intent.putExtra("time", time)
        intent.putExtra("country", getCountry())
        startActivity(intent)
    }

    private fun getCountry(): String {
        //TODO actually implement getting from UI
        return "Polska"
    }
}