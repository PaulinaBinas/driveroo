package com.pbinas.driveroo.ui.chooseTime

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.chooseCountry.ChooseCountryActivity
import java.text.SimpleDateFormat
import java.util.*

class ChooseTimeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_time)
        var dateTime = Calendar.getInstance().time
        var dateText : TextView = findViewById(R.id.dateText)
        dateText.text = dateTime.toString("dd-MM-yyyy")
        var timeText : TextView = findViewById(R.id.timeText)
        timeText.text = dateTime.toString("HH:mm")
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun goFurther(view: View) {
        var intent = Intent(this, ChooseCountryActivity::class.java)
        startActivity(intent)
    }
}