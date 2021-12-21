package com.pbinas.driveroo.ui.chooseTime

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.pbinas.driveroo.R
import com.pbinas.driveroo.ui.base.view.BaseActivity
import com.pbinas.driveroo.ui.chooseCountry.view.ChooseCountryActivity
import com.pbinas.driveroo.ui.picker.DatePickerFragment
import com.pbinas.driveroo.ui.picker.TimePickerFragment
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class ChooseTimeActivity : BaseActivity(), ChooseTimeView {
    var type: String = ""
    private var id: Int? = null
    private var date: String? = null
    private var time: String? = null
    private var country: String? = null
    private final var timeInPl = " UTC+1 (w Polsce)"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_time)
        var ids = TimeZone.getAvailableIDs()
        var calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Warsaw"))
        var dateTime = calendar.time
        var dateText : TextView = findViewById(R.id.dateText)
        date = dateTime.toString("dd/MM/yyyy")
        dateText.text = date
        var timeText : TextView = findViewById(R.id.timeText)
        time = dateTime.toString("HH:mm")
        timeText.text = time + timeInPl
        type = intent.getStringExtra("type") ?: ""
        id = intent.extras?.getInt("id", -1)
        if(id != null && id!! > -1) {
            date = intent.extras?.getString("date") ?: ""
            time = intent.extras?.getString("time") ?: ""
            country = intent.extras?.getString("country") ?: ""
            dateText.text = date
            timeText.text = time
        }
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
        if(id != null && id!! > -1) {
            intent.putExtra("id", id)
            intent.putExtra("country", country)
        }
        startActivity(intent)
    }

    override fun setNewTime(hour: Int, minute: Int) {
        var timeText : TextView = findViewById(R.id.timeText)
        time = LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm"))
        timeText.text = LocalTime.of(hour, minute).format(DateTimeFormatter.ofPattern("HH:mm")) + timeInPl
    }

    override fun setNewDate(year: Int, month: Int, day: Int) {
        var dateText : TextView = findViewById(R.id.dateText)
        date = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        dateText.text = LocalDate.of(year, month, day).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }

    override fun getDate(): String {
        return date ?: ""
    }

    override fun getTime(): String {
        return time ?: ""
    }

    fun changeTime(view: View) {
        TimePickerFragment().show(supportFragmentManager, "timePicker")
    }

    fun changeDate(view: View) {
        DatePickerFragment().show(supportFragmentManager, "datePicker")
    }
}