package com.pbinas.driveroo.ui.addNewEntry.view

import com.pbinas.driveroo.ui.base.view.BaseView

interface AddNewEntryView: BaseView {

    fun getId(): Int?
    fun getDate(): String?
    fun getTime(): String?
    fun getCountry(): String?
}