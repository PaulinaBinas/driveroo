package com.pbinas.driveroo.ui.mainMenu.view

import com.pbinas.driveroo.ui.base.view.BaseView

interface MainMenuView: BaseView {

    fun setTitle(firstName: String, surname: String)
}