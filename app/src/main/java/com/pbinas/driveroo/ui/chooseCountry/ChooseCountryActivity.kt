package com.pbinas.driveroo.ui.chooseCountry

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.details.DetailsActivity
import com.pbinas.driveroo.ui.base.view.BaseActivity

class ChooseCountryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_country)
    }

    fun goFurther(view: View) {
        var intent = Intent(this, DetailsActivity::class.java)
        startActivity(intent)
    }
}