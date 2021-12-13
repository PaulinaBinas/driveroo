package com.pbinas.driveroo.ui.details.view

import com.pbinas.driveroo.ui.base.view.BaseView

interface DetailsView: BaseView {

    fun setType(type: String)
    fun setDate(date: String)
    fun setTime(time: String)
    fun setCountry(country: String)
    fun setValues()
}