package com.pbinas.driveroo.ui.picker

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.pbinas.driveroo.ui.chooseTime.ChooseTimeView
import java.time.LocalTime
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var hour = 0
        var minute = 0
        var c = Calendar.getInstance()
        if(activity is ChooseTimeView) {
            var time = (activity as ChooseTimeView).getTime()

            var localTime = LocalTime.parse(time)
            hour = localTime.hour
            minute = localTime.minute
        } else {
            hour = c.get(Calendar.HOUR_OF_DAY)
            minute = c.get(Calendar.MINUTE)
        }

        return TimePickerDialog(activity, this, hour, minute, true)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        if(activity is ChooseTimeView) {
            (activity as ChooseTimeView).setNewTime(p1, p2)
        }
    }
}