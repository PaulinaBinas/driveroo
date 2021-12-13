package com.pbinas.driveroo.ui.chooseTime

import com.pbinas.driveroo.ui.base.view.BaseView

interface ChooseTimeView: BaseView {

    fun setNewTime(hour: Int, minute: Int)

    fun setNewDate(year: Int, month: Int, day: Int)

    fun getDate(): String

    fun getTime(): String
}