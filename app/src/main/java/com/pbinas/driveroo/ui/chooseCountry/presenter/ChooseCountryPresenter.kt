package com.pbinas.driveroo.ui.chooseCountry.presenter

import android.content.Context
import com.pbinas.driveroo.databinding.ActivityChooseCountryBinding
import com.pbinas.driveroo.ui.base.presenter.Presenter
import com.pbinas.driveroo.ui.chooseCountry.interactor.ChooseCountryInteractor
import com.pbinas.driveroo.ui.chooseCountry.view.ChooseCountryView

interface ChooseCountryPresenter<V: ChooseCountryView, I: ChooseCountryInteractor>: Presenter<V, I> {

    fun updateChosenItem(position: Int)

    fun getNameOfChosenCountry(): String

    fun setViewValues(binding: ActivityChooseCountryBinding, context: Context)
}