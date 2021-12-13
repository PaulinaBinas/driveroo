package com.pbinas.driveroo.ui.chooseTime

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.chooseCountry.ChooseCountryActivity
import com.pbinas.driveroo.ui.picker.DatePickerFragment
import com.pbinas.driveroo.ui.picker.TimePickerFragment
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class ChooseTimeActivity : BaseActivity(), ChooseTimeView {
    var type: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_time)
        var dateTime = Calendar.getInstance().time
        var dateText : TextView = findViewById(R.id.dateText)
        dateText.text = dateTime.toString("dd-MM-yyyy")
        var timeText : TextView = findViewById(R.id.timeText)
        timeText.text = dateTime.toString("HH:mm")
        type = intent.getStringExtra("type") ?: ""
    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun goFurther(view: View) {
        var intent = Intent(this, ChooseCountryActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("date", getDate())
        intent.putExtra("time", getTime())
        startActivity(intent)
    }

    override fun setNewTime(hour: Int, minute: Int) {
        var timeText : TextView = findViewById(R.id.timeText)
        timeText.text = LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    override fun setNewDate(year: Int, month: Int, day: Int) {
        var dateText : TextView = findViewById(R.id.dateText)
        dateText.text = "$day-$month-$year"
    }

    override fun getDate(): String {
        var dateText : TextView = findViewById(R.id.dateText)
        return dateText.text.toString()
    }

    override fun getTime(): String {
        var timeText : TextView = findViewById(R.id.timeText)
        return timeText.text.toString()
    }

    fun changeTime(view: View) {
        TimePickerFragment().show(supportFragmentManager, "timePicker")
    }

    fun changeDate(view: View) {
        DatePickerFragment().show(supportFragmentManager, "datePicker")
    }
}