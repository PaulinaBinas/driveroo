package com.pbinas.driveroo.ui.picker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.pbinas.driveroo.ui.chooseTime.ChooseTimeView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var year: Int
        var month: Int
        var dayOfMonth: Int
        var c = Calendar.getInstance()
        if(activity is ChooseTimeView) {
            var date = (activity as ChooseTimeView).getDate()
            var localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            year = localDate.year
            month = localDate.monthValue - 1
            dayOfMonth = localDate.dayOfMonth
        } else {
            year = c.get(Calendar.YEAR)
            month = c.get(Calendar.MONTH)
            dayOfMonth = c.get(Calendar.DAY_OF_MONTH)
        }

        return DatePickerDialog(activity!!, this, year, month, dayOfMonth)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        if(activity is ChooseTimeView) {
            (activity as ChooseTimeView).setNewDate(p1, p2 + 1, p3)
        }
    }
}